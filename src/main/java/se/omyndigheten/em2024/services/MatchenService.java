package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.Matchen;

import java.util.List;

/**
 * Created by Krille on 15/06/2024 12:33
 */
public interface MatchenService {
    public List<Matchen> getPlayedMatches();
    public Matchen getMatchFromId(long matchenId);
}
