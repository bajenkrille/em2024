package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface LigaDao {

    Liga getById(Long id);

    Liga findLigaByName(String name);

    Liga saveNewLiga(Liga liga);

    Liga updateLiga(Liga liga);

    void deleteLigaById(Long id);
}
