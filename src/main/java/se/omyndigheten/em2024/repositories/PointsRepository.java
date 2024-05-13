package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omyndigheten.em2024.domain.Points;

/**
 * Created by Krille on 07/05/2024 20:39
 */
public interface PointsRepository extends JpaRepository<Points, Long> {
}
