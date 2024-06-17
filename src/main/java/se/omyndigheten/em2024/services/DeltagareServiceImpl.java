package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.DeltagareDao;
import se.omyndigheten.em2024.domain.Deltagare;

import java.util.List;

/**
 * Created by Krille on 23/05/2024 20:09
 */
@Service
public class DeltagareServiceImpl implements DeltagareService {

    private DeltagareDao deltagareDao;

    public DeltagareServiceImpl(DeltagareDao deltagareDao) {
        this.deltagareDao = deltagareDao;
    }
    @Override
    public Deltagare saveDeltagare(Deltagare deltagare) {
        return deltagareDao.saveNewDeltagare(deltagare);
    }
    @Override
    public Deltagare getDeltagareById(Long id) {
        return deltagareDao.getById(id);
    }

    @Override
    public List<Deltagare> getAllaDeltagare() {
        return deltagareDao.findAll();
    }

    @Override
    public Deltagare findDeltagareByNickname(String nickName) {
        return deltagareDao.findDeltagareByNickname(nickName);
    }
    @Override
    public boolean doesNicknameExist(String nickName) {
        return findDeltagareByNickname(nickName).getNickName().equals(nickName);
    }

}
