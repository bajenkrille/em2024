package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.MatchDao;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Krille on 27/05/2024 22:36
 */
@Service
public class TipsServiceImpl implements TipsService {

    private MatchDao matchDao;
    private Map<Long,Matchen> matchenMap = new HashMap<>();

    public TipsServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }
    @Override
    public Map<Long,Matchen> getAllMatches() {
        for (long id = 1; id <= 36; id++){
            matchenMap.put(id, matchDao.getById(id));
        }
        return matchenMap;
    }
}
