package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;

import java.util.Optional;
import java.util.Set;

/**
 * Created by Krille on 07/05/2024 20:37
 */
public interface LigaRepository extends JpaRepository<Liga, Long> {
    Optional<Liga> findLigaByLigaName(String name);
    @Query("SELECT l.deltagareSet FROM Liga l WHERE l.id = :ligaId")
    Optional<Set<Deltagare>> findDeltagareByLigaId(@Param("ligaId") Long ligaId);

}
