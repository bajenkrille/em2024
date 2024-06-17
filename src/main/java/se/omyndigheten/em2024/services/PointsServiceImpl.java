package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.PointsDao;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.domain.Points;

import java.util.List;
import java.util.Set;

/**
 * Created by Krille on 14/06/2024 16:17
 */
@Service
public class PointsServiceImpl implements PointsService {
    private PointsDao pointsDao;
    private MatchenService matchenService;
    private MatchTipsService matchTipsService;
    private DeltagareService deltagareService;

    public PointsServiceImpl(PointsDao pointsDao, MatchenService matchenService, MatchTipsService matchTipsService, DeltagareService deltagareService) {
        this.pointsDao = pointsDao;
        this.matchenService = matchenService;
        this.matchTipsService = matchTipsService;
        this.deltagareService = deltagareService;
    }
    private String get1X2(int hemma, int borta){
        if (hemma > borta){
            return "1";
        } else if (hemma == borta) {
            return "X";
        } else {
            return "2";
        }
    }

    private int getPoints(Long deltagareId, Matchen matchen) {
        int points;
        int gjordaHemmaMal = matchen.getHemmaMal();
        int gjordaBortaMal = matchen.getBortaMal();
        String matchTecken = get1X2(gjordaHemmaMal,gjordaBortaMal);
        MatchTips matchTips = matchTipsService.getMatchTipsByDeltagareAndMatch(deltagareId, matchen.getId());
        int tippadeHemmaMal = matchTips.getHemmaMal();
        int tippadeBortaMal = matchTips.getBortaMal();
        boolean rattResultat = (gjordaHemmaMal == tippadeHemmaMal && gjordaBortaMal == tippadeBortaMal);
        if (!rattResultat){
            String tippatTecken = get1X2(tippadeHemmaMal,tippadeBortaMal);
            boolean rattTecken = (matchTecken == tippatTecken);
            points = rattTecken ? 1 : 0;
        } else {
            int gjordaMal = gjordaHemmaMal + gjordaBortaMal;
            points = gjordaMal > 3 ? 3: 2;
        }
        return points;
    }
    @Override
    public void savePoints(MatchTips matchTips) {
        Points points = new Points();
        long deltagareId = matchTips.getDeltagare().getId();
        long matchenId = matchTips.getMatchen().getId();
        points.setDeltagare(deltagareService.getDeltagareById(deltagareId));
        points.setMatchTips(matchTipsService.getMatchTipsByDeltagareAndMatch(deltagareId,matchenId));
        points.setPoints(getPointsForDeltagare(deltagareId,matchenId));
        if (!pointsDao.isPointsByMatchTipsId(matchTips.getId())){
            pointsDao.saveNewPoints(points);
        }
    }
    @Override
    public int getPointsForDeltagare(Long deltagareId, Long matchenId) {
        Matchen matchen = matchenService.getMatchFromId(matchenId);
        MatchTips matchTips = matchTipsService.getMatchTipsByDeltagareAndMatch(deltagareId,matchenId);
        int points = 0;
        return getPoints(deltagareId,matchen);
    }

    @Override
    public int getPointsForDeltagareId(long deltagareId) {
        Set<Points> pointsSet = pointsDao.getPointsForDeltagareId(deltagareId);
        int sumPoints = 0;
        for (Points points:pointsSet) {
            sumPoints += points.getPoints();
        }
        return sumPoints;
    }

    @Override
    public int calculatePointsForDeltagare(Long deltagareId) {
        List<Matchen> speladeMatcher = matchenService.getPlayedMatches();
        int points = 0;
        for (Matchen matchen:speladeMatcher) {
            points = getPoints(deltagareId, matchen);
        }
        return points;
    }
}
