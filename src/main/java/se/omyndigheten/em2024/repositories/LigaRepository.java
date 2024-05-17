package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omyndigheten.em2024.domain.Liga;

import java.util.Optional;

/**
 * Created by Krille on 07/05/2024 20:37
 */
public interface LigaRepository extends JpaRepository<Liga, Long> {
    Optional<Liga> findLigaByLigaName(String name);
}
