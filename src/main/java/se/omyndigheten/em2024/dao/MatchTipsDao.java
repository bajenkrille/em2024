package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.MatchTips;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface MatchTipsDao {

    MatchTips getById(Long id);

    //Tips findDeltagareByName(String firstName, String lastName);

    MatchTips saveNewMatchTips(MatchTips matchTips);

    MatchTips updateMatchTips(MatchTips matchTips);

    void deleteMatchTipsById(Long id);
}
