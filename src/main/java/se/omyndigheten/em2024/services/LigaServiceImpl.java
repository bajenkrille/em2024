package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.omyndigheten.em2024.dao.DeltagareDao;
import se.omyndigheten.em2024.dao.LigaDao;
import se.omyndigheten.em2024.dao.PointsDao;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krille on 16/06/2024 21:08
 */
@Service
public class LigaServiceImpl implements LigaService {

    private LigaDao ligaDao;
    private DeltagareDao deltagareDao;
    private PointsService pointsService;

    public LigaServiceImpl(LigaDao ligaDao, DeltagareDao deltagareDao, PointsDao pointsDao, PointsService pointsService) {
        this.ligaDao = ligaDao;
        this.deltagareDao = deltagareDao;
        this.pointsService = pointsService;
    }

    @Transactional
    @Override
    public Liga skapaLiga(String ligaNamn, String beskrivning, Set<Deltagare> deltagareSet){
        Liga liga = new Liga();
        liga.setLigaName(ligaNamn);
        liga.setDescription(beskrivning);
        liga.setDeltagareSet(deltagareSet);
        for (Deltagare deltagare:deltagareSet) {
            liga.addDeltagare(deltagare);
        }
        return ligaDao.saveNewLiga(liga);
    }

    @Transactional
    public void addDeltagareToLiga(Long ligaId, Deltagare deltagare) {
        Liga liga = ligaDao.getById(ligaId);
        liga.addDeltagare(deltagare);
        deltagareDao.saveNewDeltagare(deltagare);
    }

    public Set<Deltagare> findDeltagareByLiga(String liga){
        Long ligaId = ligaDao.findLigaByName(liga).getId();
        return ligaDao.findDeltagareByLigaId(ligaId);
    }

    public int findPointsForDeltagare(Deltagare deltagare){
        return pointsService.getPointsForDeltagareId(deltagare.getId());
    }

    @Override
    public Map<Deltagare, Integer> getLigaDeltagarePointsMap(String liga) {
        Map<Deltagare, Integer> deltagareIntegerMap = new HashMap<>();
        Set<Deltagare> deltagareSet = findDeltagareByLiga(liga);
        for (Deltagare deltagare:deltagareSet) {
            deltagareIntegerMap.put(deltagare, findPointsForDeltagare(deltagare));
        }
        return deltagareIntegerMap;
    }

    @Override
    public List<Liga> findAllaLigor() {
        return ligaDao.findAll();
    }

    @Override
    public Liga uppDateraLiga(String ligaNamn, String beskrivning, List<Deltagare> deltagareList) {
        return null;
    }
}
