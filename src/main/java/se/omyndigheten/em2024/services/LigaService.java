package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krille on 16/06/2024 21:05
 */
public interface LigaService {

    public Liga skapaLiga(String ligaNamn, String beskrivning, Set<Deltagare> deltagareSet);

    public Liga uppDateraLiga(String ligaNamn, String beskrivning, List<Deltagare> deltagareList);

    public Set<Deltagare> findDeltagareByLiga(String liga);
    public int findPointsForDeltagare(Deltagare deltagare);
    public Map<Deltagare,Integer> getLigaDeltagarePointsMap(String liga);
    public List<Liga> findAllaLigor();

}
