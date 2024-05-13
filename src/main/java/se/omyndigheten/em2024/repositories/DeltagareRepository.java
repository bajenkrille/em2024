package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omyndigheten.em2024.domain.Deltagare;

import java.util.Optional;

/**
 * Created by Krille on 07/05/2024 20:35
 */
public interface DeltagareRepository extends JpaRepository<Deltagare, Long> {
    Optional<Deltagare> findDeltagareByFirstNameAndLastName(String firstName, String lastName);
}
