package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omyndigheten.em2024.domain.Points;
import se.omyndigheten.em2024.domain.Spelschema;

/**
 * Created by Krille on 07/05/2024 20:39
 */
public interface SpelschemaRepository extends JpaRepository<Spelschema, Long> {
}
