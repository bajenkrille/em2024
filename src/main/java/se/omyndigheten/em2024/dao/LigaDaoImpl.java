package se.omyndigheten.em2024.dao;

import jakarta.transaction.Transactional;
import se.omyndigheten.em2024.domain.Liga;
import se.omyndigheten.em2024.repositories.LigaRepository;

/**
 * Created by Krille on 09/05/2024 13:33
 */
public class LigaDaoImpl implements LigaDao {

    private final LigaRepository ligaRepository;

    public LigaDaoImpl(LigaRepository ligaRepository) {
        this.ligaRepository = ligaRepository;
    }

    @Override
    public Liga getById(Long id) {
        return ligaRepository.getReferenceById(id);
    }

    @Override
    public Liga findLigaByName(String name) {
        return ligaRepository.findLigaByLigaName(name)
                .orElseThrow();
    }

    @Override
    public Liga saveNewLiga(Liga liga) {
        return ligaRepository.save(liga);
    }

    @Override
    @Transactional
    public Liga updateLiga(Liga liga) {
        Liga foundLiga = ligaRepository.getReferenceById(liga.getId());
        foundLiga.setLigaName(liga.getLigaName());
        foundLiga.setDescription(liga.getDescription());
        return ligaRepository.save(foundLiga);
    }

    @Override
    public void deleteLigaById(Long id) {
        ligaRepository.deleteById(id);
    }
}
