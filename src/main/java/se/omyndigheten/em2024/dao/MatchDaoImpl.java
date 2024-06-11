package se.omyndigheten.em2024.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.repositories.MatchRepository;

import java.util.Optional;

/**
 * Created by Krille on 09/05/2024 13:48
 */
@Component
public class MatchDaoImpl implements MatchDao {
    private final MatchRepository matchRepository;

    public MatchDaoImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Matchen getById(Long id) {
        Optional<Matchen> matchenOptional = matchRepository.findById(id);
        return matchenOptional.get();
    }

    @Override
    public Matchen saveNewMatch(Matchen matchen) {
        return matchRepository.save(matchen);
    }

    @Override
    @Transactional
    public Matchen updateMatch(Matchen matchen) {
        Matchen foundMatchen = matchRepository.getReferenceById(matchen.getId());
        foundMatchen.setHemmaMal(matchen.getHemmaMal());
        foundMatchen.setBortaMal(matchen.getBortaMal());
        return matchRepository.save(foundMatchen);
    }

    @Override
    public void deleteMatchById(Long id) {
        matchRepository.deleteById(id);
    }
}
