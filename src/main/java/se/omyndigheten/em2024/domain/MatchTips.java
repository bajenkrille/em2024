package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Created by Krille on 01/05/2024 19:56
 */
@Entity
public class MatchTips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int hemmaMal;
    private int bortaMal;
    @ManyToOne
    private Deltagare deltagare;
    @ManyToOne
    private Matchen matchen;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getHemmaMal() {
        return hemmaMal;
    }

    public void setHemmaMal(int tipsHemmaMal) {
        this.hemmaMal = tipsHemmaMal;
    }

    public int getBortaMal() {
        return bortaMal;
    }

    public void setBortaMal(int tipsBortaMal) {
        this.bortaMal = tipsBortaMal;
    }

    public Deltagare getDeltagare() {
        return deltagare;
    }

    public void setDeltagare(Deltagare deltagare) {
        this.deltagare = deltagare;
    }

    public Matchen getMatchen() {
        return matchen;
    }

    public void setMatchen(Matchen matchen) {
        this.matchen = matchen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatchTips matchTips = (MatchTips) o;

        if (hemmaMal != matchTips.hemmaMal) return false;
        if (bortaMal != matchTips.bortaMal) return false;
        if (!Objects.equals(id, matchTips.id)) return false;
        if (!Objects.equals(deltagare, matchTips.deltagare)) return false;
        return Objects.equals(matchen, matchTips.matchen);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + hemmaMal;
        result = 31 * result + bortaMal;
        result = 31 * result + (deltagare != null ? deltagare.hashCode() : 0);
        result = 31 * result + (matchen != null ? matchen.hashCode() : 0);
        return result;
    }
}
