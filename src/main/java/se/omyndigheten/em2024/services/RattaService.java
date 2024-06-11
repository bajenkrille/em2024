package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.Matchen;

import java.util.List;

/**
 * Created by Krille on 11/06/2024 23:05
 */
public interface RattaService {

    public void saveRattadMatch(Matchen matchen);
    public List<Matchen> getAllMatches();

}
