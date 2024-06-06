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
    private Integer hemmaMal;
    private Integer bortaMal;
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

    public Integer getHemmaMal() {
        return hemmaMal;
    }

    public void setHemmaMal(Integer hemmaMal) {
        this.hemmaMal = hemmaMal;
    }

    public Integer getBortaMal() {
        return bortaMal;
    }

    public void setBortaMal(Integer bortaMal) {
        this.bortaMal = bortaMal;
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

        if (!Objects.equals(id, matchTips.id)) return false;
        if (!Objects.equals(hemmaMal, matchTips.hemmaMal)) return false;
        if (!Objects.equals(bortaMal, matchTips.bortaMal)) return false;
        if (!Objects.equals(deltagare, matchTips.deltagare)) return false;
        return Objects.equals(matchen, matchTips.matchen);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hemmaMal != null ? hemmaMal.hashCode() : 0);
        result = 31 * result + (bortaMal != null ? bortaMal.hashCode() : 0);
        result = 31 * result + (deltagare != null ? deltagare.hashCode() : 0);
        result = 31 * result + (matchen != null ? matchen.hashCode() : 0);
        return result;
    }
}
