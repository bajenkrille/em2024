package se.omyndigheten.em2024.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Created by Krille on 07/05/2024 20:16
 */
@Entity
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int points;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
