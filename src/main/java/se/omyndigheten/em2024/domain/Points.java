package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Created by Krille on 07/05/2024 20:16
 */
@Entity
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int points;
    @ManyToOne
    private Deltagare deltagare;
    @OneToOne
    private MatchTips matchTips;

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

    public Deltagare getDeltagare() {
        return deltagare;
    }

    public void setDeltagare(Deltagare deltagare) {
        this.deltagare = deltagare;
    }

    public MatchTips getMatchTips() {
        return matchTips;
    }

    public void setMatchTips(MatchTips matchTips) {
        this.matchTips = matchTips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Points points1 = (Points) o;

        if (points != points1.points) return false;
        if (!Objects.equals(id, points1.id)) return false;
        if (!Objects.equals(deltagare, points1.deltagare)) return false;
        return Objects.equals(matchTips, points1.matchTips);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + points;
        result = 31 * result + (deltagare != null ? deltagare.hashCode() : 0);
        result = 31 * result + (matchTips != null ? matchTips.hashCode() : 0);
        return result;
    }
}
