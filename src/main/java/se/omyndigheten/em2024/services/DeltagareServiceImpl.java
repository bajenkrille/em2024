package se.omyndigheten.em2024.services;

import org.springframework.stereotype.Service;
import se.omyndigheten.em2024.dao.DeltagareDao;
import se.omyndigheten.em2024.domain.Deltagare;

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
}
