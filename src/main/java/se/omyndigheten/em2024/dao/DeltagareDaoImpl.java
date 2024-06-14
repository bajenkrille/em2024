package se.omyndigheten.em2024.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.repositories.DeltagareRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by Krille on 07/05/2024 21:00
 */
@Component
public class DeltagareDaoImpl implements DeltagareDao {

    private final DeltagareRepository deltagareRepository;

    public DeltagareDaoImpl(DeltagareRepository deltagareRepository) {
        this.deltagareRepository = deltagareRepository;
    }

    @Override
    public Deltagare getById(Long id) {
        return deltagareRepository.getReferenceById(id);
    }

    @Override
    public List<Deltagare> findAll() {
        return deltagareRepository.findAll();
    }

    @Override
    public Deltagare findDeltagareByName(String firstName, String lastName) {
        return deltagareRepository.findDeltagareByFirstNameAndLastName(firstName, lastName)
                .orElseThrow();
    }

    @Override
    public Deltagare findDeltagareByEmail(String email) {
        return deltagareRepository.getDeltagareByEmail(email).orElseThrow();
    }

    @Override
    public Deltagare findDeltagareByNickname(String nickName) {
        try {
            return deltagareRepository.findDeltagareByNickName(nickName).orElseThrow();
        } catch (NoSuchElementException e){
            return new Deltagare();
        }
    }

    @Override
    public Deltagare saveNewDeltagare(Deltagare deltagare) {
        return deltagareRepository.save(deltagare);
    }

    @Override
    @Transactional
    public Deltagare updateDeltagare(Deltagare deltagare) {
        Deltagare foundDeltagare = deltagareRepository.getReferenceById(deltagare.getId());
        foundDeltagare.setFirstName(deltagare.getFirstName());
        foundDeltagare.setLastName(deltagare.getLastName());
        return deltagareRepository.save(foundDeltagare);
    }

    @Override
    public void deleteDeltagareById(Long id) {
        deltagareRepository.deleteById(id);
    }
}
