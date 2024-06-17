package se.omyndigheten.em2024.dao;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import se.omyndigheten.em2024.domain.Points;
import se.omyndigheten.em2024.repositories.PointsRepository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Krille on 09/05/2024 13:57
 */
@Component
public class PointsDaoImpl implements PointsDao {
    private final PointsRepository pointsRepository;

    public PointsDaoImpl(PointsRepository pointsRepository) {
        this.pointsRepository = pointsRepository;
    }

    @Override
    public Points getById(Long id) {
        return pointsRepository.getReferenceById(id);
    }

    @Override
    public Set<Points> getPointsForDeltagareId(long deltagareId) {
        try {
            return pointsRepository.getAllByDeltagare_Id(deltagareId).orElseThrow();
        } catch (NoSuchElementException e){
            return new HashSet<>();
        }
    }

    @Override
    public Points saveNewPoints(Points points) {
        return pointsRepository.save(points);
    }

    @Override
    public boolean isPointsByMatchTipsId(long matchTipsId) {
        try {
            Points points = pointsRepository.getPointsByMatchTips_Id(matchTipsId).get();
        } catch (NoSuchElementException e){
            return false;
        }

        return true;

    }

    @Override
    @Transactional
    public Points updatePoints(Points points) {
        Points foundPoints = pointsRepository.getReferenceById(points.getId());
        foundPoints.setPoints(points.getPoints());
        return pointsRepository.save(foundPoints);
    }

    @Override
    public void deletePointsById(Long id) {
        pointsRepository.deleteById(id);
    }
}
