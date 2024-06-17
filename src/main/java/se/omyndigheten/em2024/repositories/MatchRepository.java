package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omyndigheten.em2024.domain.Matchen;

import java.util.Optional;

/**
 * Created by Krille on 07/05/2024 20:38
 */
public interface MatchRepository extends JpaRepository<Matchen, Long> {
    Optional<Matchen> findMatchenByPlayed(boolean played);
}
