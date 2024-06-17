package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Points;

import java.util.Set;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface PointsDao {

    Points getById(Long id);

    //Points findPointsByName(String firstName, String lastName);
    Set<Points> getPointsForDeltagareId(long deltagareId);

    Points saveNewPoints(Points points);

    boolean isPointsByMatchTipsId(long matchTipsId);

    Points updatePoints(Points points);

    void deletePointsById(Long id);
}
