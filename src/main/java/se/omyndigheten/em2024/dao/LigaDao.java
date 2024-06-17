package se.omyndigheten.em2024.dao;

import jakarta.mail.search.SearchTerm;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;

import java.util.List;
import java.util.Set;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface LigaDao {

    Liga getById(Long id);

    Liga findLigaByName(String name);
    List<Liga> findAll();

    Liga saveNewLiga(Liga liga);

    Liga updateLiga(Liga liga);

    Set<Deltagare> findDeltagareByLigaId(Long ligaId);

    void deleteLigaById(Long id);
}
