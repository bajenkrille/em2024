package se.omyndigheten.em2024.dao;

import jakarta.transaction.Transactional;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.repositories.MatchTipsRepository;

/**
 * Created by Krille on 09/05/2024 14:04
 */
public class MatchTipsDaoImpl implements MatchTipsDao {
    private final MatchTipsRepository matchTipsRepository;

    public MatchTipsDaoImpl(MatchTipsRepository matchTipsRepository) {
        this.matchTipsRepository = matchTipsRepository;
    }

    @Override
    public MatchTips getById(Long id) {
        return matchTipsRepository.getReferenceById(id);
    }

    @Override
    public MatchTips saveNewMatchTips(MatchTips matchTips) {
        return matchTipsRepository.save(matchTips);
    }

    @Override
    @Transactional
    public MatchTips updateMatchTips(MatchTips matchTips) {
        MatchTips foundMatchTips = matchTipsRepository.getReferenceById(matchTips.getMatchTipsId());
        foundMatchTips.setHemmaMal(matchTips.getHemmaMal());
        foundMatchTips.setBortaMal(matchTips.getBortaMal());
        return matchTipsRepository.save(foundMatchTips);
    }

    @Override
    public void deleteMatchTipsById(Long id) {
        matchTipsRepository.deleteById(id);
    }
}
