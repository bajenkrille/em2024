package se.omyndigheten.em2024.dao;

import se.omyndigheten.em2024.domain.Deltagare;

import java.util.Optional;

/**
 * Created by Krille on 07/05/2024 20:42
 */
public interface DeltagareDao {

    Deltagare getById(Long id);

    Deltagare findDeltagareByName(String firstName, String lastName);
    Deltagare findDeltagareByEmail(String email);
    Deltagare findDeltagareByNickname(String nickName);

    Deltagare saveNewDeltagare(Deltagare deltagare);

    Deltagare updateDeltagare(Deltagare deltagare);

    void deleteDeltagareById(Long id);
}
