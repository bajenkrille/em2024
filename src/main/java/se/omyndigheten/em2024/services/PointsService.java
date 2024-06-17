package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.MatchTips;

/**
 * Created by Krille on 14/06/2024 15:13
 */
public interface PointsService {

    public void savePoints(MatchTips matchTips);

    public int getPointsForDeltagare(Long deltagareId, Long matchenId);
    public int getPointsForDeltagareId(long deltagareId);

    public int calculatePointsForDeltagare(Long deltagareId);
}
