package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.MatchDao;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krille on 15/06/2024 12:36
 */
@Service
public class MatchenServiceImpl implements MatchenService {
    private MatchDao matchDao;

    public MatchenServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override
    public Matchen getMatchFromId(long matchenId) {
        return matchDao.getById(matchenId);
    }

    @Override
    public List<Matchen> getPlayedMatches() {
        List<Matchen> matchenList = new ArrayList<>();
        boolean played = true;
        long n = 1;
        while (played && n <= 36){
            Matchen matchen = matchDao.getById(n);
            played = matchen.isPlayed();
            if (played){
                matchenList.add(matchen);
            }
            n++;
        }
        return matchenList;
    }
}
