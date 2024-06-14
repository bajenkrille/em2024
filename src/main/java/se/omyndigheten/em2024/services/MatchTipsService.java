package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.MatchTips;

import java.util.List;
import java.util.Map;

/**
 * Created by Krille on 27/05/2024 23:08
 */
public interface MatchTipsService {
    public void saveMatchTips(List<MatchTips> matchTipsList);
    public void saveMatchTips(List<MatchTips> matchTipsList, Deltagare deltagare);
    public List<MatchTips> getMatchTipsList();
    public Map<Long, List<String>> getListOfDeltagareAndTips();

}
