package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Spelschema;
import se.omyndigheten.em2024.repositories.SpelschemaRepository;

/**
 * Created by Krille on 16/05/2024 22:24
 */
public class SpelschemaDaoImpl implements SpelschemaDao {
    private final SpelschemaRepository spelschemaRepository;

    public SpelschemaDaoImpl(SpelschemaRepository spelschemaRepository) {
        this.spelschemaRepository = spelschemaRepository;
    }

    @Override
    public Spelschema getById(Long id) {
        return spelschemaRepository.getReferenceById(id);
    }

    @Override
    public Spelschema saveNewSpelschema(Spelschema spelschema) {
        return spelschemaRepository.save(spelschema);
    }

    @Override
    public Spelschema updateSpelschema(Spelschema spelschema) {
        Spelschema foundSpelschema = spelschemaRepository.getReferenceById(spelschema.getId());
        foundSpelschema.setDate(spelschema.getDate());
        foundSpelschema.setTime(spelschema.getTime());
        foundSpelschema.setLocation(spelschema.getLocation());
        return spelschemaRepository.save(foundSpelschema);
    }

    @Override
    public void deleteSpelschemaById(Long id) {
        spelschemaRepository.deleteById(id);
    }
}
