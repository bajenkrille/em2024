package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Points;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface PointsDao {

    Points getById(Long id);

    //Points findPointsByName(String firstName, String lastName);

    Points saveNewPoints(Points points);

    Points updatePoints(Points points);

    void deletePointsById(Long id);
}
