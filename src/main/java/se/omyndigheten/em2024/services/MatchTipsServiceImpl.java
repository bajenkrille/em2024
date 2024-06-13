package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.MatchDao;
import se.omyndigheten.em2024.dao.MatchTipsDao;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krille on 27/05/2024 23:09
 */
@Service
public class MatchTipsServiceImpl implements MatchTipsService {

    private MatchTipsDao matchTipsDao;
    private MatchDao matchDao;
    private WriteToFile writeToFile;

    public MatchTipsServiceImpl(MatchTipsDao matchTipsDao, MatchDao matchDao, WriteToFile writeToFile) {
        this.matchTipsDao = matchTipsDao;
        this.matchDao = matchDao;
        this.writeToFile = writeToFile;
    }

    @Override
    public void saveMatchTips(List<MatchTips> matchTipsList) {
        for (MatchTips matchTips:matchTipsList){
            matchTipsDao.saveNewMatchTips(matchTips);
        }
    }
    @Override
    public void saveMatchTips(List<MatchTips> matchTipsList, Deltagare deltagare) {
        for (MatchTips matchTips:matchTipsList){
            matchTips.setDeltagare(deltagare);
            matchTipsDao.saveNewMatchTips(matchTips);
        }
        writeToFile.writeTipsToFile(matchTipsList,deltagare.getNickName());
    }
    @Override
    public List<MatchTips> getMatchTipsList() {
        List<MatchTips> matchTipsList = new ArrayList<>();
        for (long n = 1; n <= 36; n++) {
            Matchen matchen = matchDao.getById(n);
            MatchTips matchTips = new MatchTips();
            matchTips.setMatchen(matchen);
            matchTipsList.add(matchTips);
        }
        return matchTipsList;
    }
}
