package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Krille on 15/06/2024 16:11
 */
@Service
public class StallningServiceImpl implements StallningService {
    private PointsService pointsService;
    private DeltagareService deltagareService;
    private MatchenService matchenService;
    private MatchTipsService matchTipsService;

    public StallningServiceImpl(PointsService pointsService, DeltagareService deltagareService, MatchenService matchenService, MatchTipsService matchTipsService) {
        this.pointsService = pointsService;
        this.deltagareService = deltagareService;
        this.matchenService = matchenService;
        this.matchTipsService = matchTipsService;
    }

    public void savePointsForAllDeltagareAndMatches(){
        List<Matchen> matchenList = matchenService.getPlayedMatches();
        List<Deltagare> deltagareList = deltagareService.getAllaDeltagare();
        for (Matchen matchen:matchenList) {
            for (Deltagare deltagare:deltagareList) {
                MatchTips matchTips = matchTipsService.getMatchTipsByDeltagareAndMatch(deltagare.getId(),matchen.getId());
                pointsService.savePoints(matchTips);
            }
        }
    };
    @Override
    public Map<String,Integer> getPointsForDeltagare() {
        List<Deltagare> deltagareList = deltagareService.getAllaDeltagare();
        List<Matchen> speladeMatcher = matchenService.getPlayedMatches();
        Map<String,Integer> pointsForAllaDeltagare = new HashMap<>();
        for (Deltagare deltagare:deltagareList) {
            Integer pointsForDeltagare = 0;
            for (Matchen matchen:speladeMatcher) {
                Integer pointsForMatch = pointsService.getPointsForDeltagare(deltagare.getId(), matchen.getId());
                pointsForDeltagare  += pointsForMatch;
            }
            pointsForAllaDeltagare.put(deltagare.getNickName(),pointsForDeltagare);
        }
        return pointsForAllaDeltagare;
    }
}
