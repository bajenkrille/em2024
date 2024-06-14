package se.omyndigheten.em2024.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omyndigheten.em2024.domain.MatchTips;

import java.util.Optional;

/**
 * Created by Krille on 07/05/2024 20:40
 */
public interface MatchTipsRepository extends JpaRepository<MatchTips, Long> {
    Optional<MatchTips> findMatchTipsByMatchenIdAndDeltagare_Id(Long matchenId, Long deltagareId);
}
