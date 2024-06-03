package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.MatchTips;

import java.util.List;

/**
 * Created by Krille on 27/05/2024 23:08
 */
public interface MatchTipsService {
    public void saveMatchTips(List<MatchTips> matchTipsList);

    public List<MatchTips> getMatchTipsList();
}
