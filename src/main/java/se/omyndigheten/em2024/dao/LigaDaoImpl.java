package se.omyndigheten.em2024.dao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;
import se.omyndigheten.em2024.repositories.LigaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by Krille on 09/05/2024 13:33
 */
@Component
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
    public List<Liga> findAll() {
        return ligaRepository.findAll();
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
    public Set<Deltagare> findDeltagareByLigaId(Long ligaId) {
        try {
            return ligaRepository.findDeltagareByLigaId(ligaId).orElseThrow();
        } catch (NoSuchElementException e) {
            return new HashSet<>();
        }
    }

    @Override
    public void deleteLigaById(Long id) {
        ligaRepository.deleteById(id);
    }
}
