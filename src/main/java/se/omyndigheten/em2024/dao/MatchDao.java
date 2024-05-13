package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Match;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface MatchDao {

    Match getById(Long id);

    //Match findMatchByName(String firstName, String lastName);

    Match saveNewMatch(Match match);

    Match updateMatch(Match match);

    void deleteMatchById(Long id);
}
