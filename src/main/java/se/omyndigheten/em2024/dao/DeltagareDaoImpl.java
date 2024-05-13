package se.omyndigheten.em2024.dao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.repositories.DeltagareRepository;

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
    public Deltagare findDeltagareByName(String firstName, String lastName) {
        return deltagareRepository.findDeltagareByFirstNameAndLastName(firstName, lastName)
                .orElseThrow();
    }

    @Override
    public Deltagare saveNewDeltagare(Deltagare deltagare) {
        return deltagareRepository.save(deltagare);
    }

    @Override
    @Transactional
    public Deltagare updateDeltagare(Deltagare deltagare) {
        Deltagare foundDeltagare = deltagareRepository.getReferenceById(deltagare.getDeltagareId());
        foundDeltagare.setFirstName(deltagare.getFirstName());
        foundDeltagare.setLastName(deltagare.getLastName());
        return deltagareRepository.save(foundDeltagare);
    }

    @Override
    public void deleteDeltagareById(Long id) {
        deltagareRepository.deleteById(id);
    }
}