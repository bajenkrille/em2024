package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Match;
import se.omyndigheten.em2024.repositories.MatchRepository;

/**
 * Created by Krille on 09/05/2024 13:48
 */
public class MatchDaoImpl implements MatchDao {
    private final MatchRepository matchRepository;

    public MatchDaoImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match getById(Long id) {
        return matchRepository.getReferenceById(id);
    }

    @Override
    public Match saveNewMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public Match updateMatch(Match match) {
        Match foundMatch = matchRepository.getReferenceById(match.getId());
        foundMatch.setHemmaMal(match.getHemmaMal());
        foundMatch.setBortaMal(match.getBortaMal());
        return matchRepository.save(foundMatch);
    }

    @Override
    public void deleteMatchById(Long id) {
        matchRepository.deleteById(id);
    }
}
