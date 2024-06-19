package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.DeltagareDao;
import se.omyndigheten.em2024.dao.MatchDao;
import se.omyndigheten.em2024.dao.MatchTipsDao;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Krille on 27/05/2024 23:09
 */
@Service
public class MatchTipsServiceImpl implements MatchTipsService {

    private MatchTipsDao matchTipsDao;
    private MatchDao matchDao;
    private DeltagareDao deltagareDao;
    private FileService fileService;

    public MatchTipsServiceImpl(MatchTipsDao matchTipsDao, MatchDao matchDao, DeltagareDao deltagareDao, FileService fileService) {
        this.matchTipsDao = matchTipsDao;
        this.matchDao = matchDao;
        this.deltagareDao = deltagareDao;
        this.fileService = fileService;
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
        fileService.writeTipsToFile(matchTipsList,deltagare.getNickName());
    }

    @Override
    public MatchTips getMatchTipsByDeltagareAndMatch(long deltagareId, long matchenId) {
        return matchTipsDao.findMatchTipsByMatchenIdAndDeltagareId(matchenId, deltagareId);
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

    @Override
    public Map<Long, List<String>> getListOfDeltagareAndTips() {
        Map<Long, List<String>> matchAndTipsMap = new HashMap<>();
        List<Deltagare> deltagareList = deltagareDao.findAll();
        List<String> nickNameList = new ArrayList<>();
        for (Deltagare deltagare:deltagareList){
            nickNameList.add(deltagare.getNickName());
        }
        matchAndTipsMap.put(0L,nickNameList);
        for (long n = 1; n <= 36; n++){
            List<String> deltagaresTipsList = new ArrayList<>();
            for (Deltagare deltagare:deltagareList){
                MatchTips matchTips = matchTipsDao.findMatchTipsByMatchenIdAndDeltagareId(n,deltagare.getId());
                if (matchTips != null) {
                    String hemmaMal = matchTips.getHemmaMal().toString();
                    String bortaMal = matchTips.getBortaMal().toString();
                    String deltagaresTips = hemmaMal + "-" + bortaMal;
                    deltagaresTipsList.add(deltagaresTips);
                }
            }
            matchAndTipsMap.put(n ,deltagaresTipsList);
        }
        return matchAndTipsMap;
    }
}
