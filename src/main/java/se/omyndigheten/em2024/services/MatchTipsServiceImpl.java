package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.MatchTipsDao;
import se.omyndigheten.em2024.domain.MatchTips;

/**
 * Created by Krille on 27/05/2024 23:09
 */
@Service
public class MatchTipsServiceImpl implements MatchTipsService {

    private MatchTipsDao matchTipsDao;

    public MatchTipsServiceImpl(MatchTipsDao matchTipsDao) {
        this.matchTipsDao = matchTipsDao;
    }
    @Override
    public MatchTips saveMatchTips(MatchTips matchTips) {
        return matchTipsDao.saveNewMatchTips(matchTips);
    }
}
