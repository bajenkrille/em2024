package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.domain.Deltagare;

import java.util.List;

/**
 * Created by Krille on 18/05/2024 19:14
 */
@Service
public interface DeltagareService {
    public Deltagare saveDeltagare(Deltagare deltagare);
    public Deltagare getDeltagareById(Long id);
    public List<Deltagare> getAllaDeltagare();
    public Deltagare findDeltagareByNickname(String nickName);
    public boolean doesNicknameExist(String nickName);

}
