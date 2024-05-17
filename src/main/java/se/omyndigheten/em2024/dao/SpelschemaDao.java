package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Points;
import se.omyndigheten.em2024.domain.Spelschema;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface SpelschemaDao {

    Spelschema getById(Long id);


    Spelschema saveNewSpelschema(Spelschema spelschema);

    Spelschema updateSpelschema(Spelschema spelschema);

    void deleteSpelschemaById(Long id);
}
