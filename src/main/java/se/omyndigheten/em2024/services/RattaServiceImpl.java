package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.MatchDao;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krille on 11/06/2024 23:12
 */
@Service
public class RattaServiceImpl implements RattaService {

    private MatchDao matchDao;

    public RattaServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }
    @Override
    public void saveRattadMatch(Matchen matchen) {
        matchDao.updateMatch(matchen);
    }

    @Override
    public List<Matchen> getAllMatches() {
        List<Matchen> matchenList = new ArrayList<>();
        for (long n = 1; n <= 36; n++) {
            Matchen matchen = matchDao.getById(n);
            matchenList.add(matchen);
        }
        return matchenList;
    }
}
