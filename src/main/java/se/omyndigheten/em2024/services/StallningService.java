package se.omyndigheten.em2024.services;

import java.util.List;
import java.util.Map;

/**
 * Created by Krille on 15/06/2024 16:09
 */
public interface StallningService {
    public Map<String,Integer> getPointsForDeltagare();
    public void savePointsForAllDeltagareAndMatches();
}
