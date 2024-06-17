package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Matchen;

import java.util.List;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface MatchDao {

    Matchen getById(Long id);

    //Match findMatchByName(String firstName, String lastName);

    Matchen saveNewMatch(Matchen matchen);

    Matchen updateMatch(Matchen matchen);

    void deleteMatchById(Long id);

    Matchen findAllPlayedMatches();

    Matchen findById(long n);
}
