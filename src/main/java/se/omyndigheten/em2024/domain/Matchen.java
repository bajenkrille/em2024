package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

/**
 * Created by Krille on 01/05/2024 19:52
 */
@Entity
public class Matchen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String datum;
    private String tid;
    private String location;
    private String grupp;
    private String hemmaLag;
    private String bortaLag;
    private Integer hemmaMal;
    private Integer bortaMal;
    private boolean played;
    @OneToMany(mappedBy = "matchen")
    private Set<MatchTips> matchTipsSet;
//    @ManyToOne
//    private Spelschema spelschema;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getHemmaLag() {
        return hemmaLag;
    }

    public void setHemmaLag(String hemmaLag) {
        this.hemmaLag = hemmaLag;
    }

    public String getBortaLag() {
        return bortaLag;
    }

    public void setBortaLag(String bortaLag) {
        this.bortaLag = bortaLag;
    }

    public int getHemmaMal() {
        return hemmaMal;
    }

    public void setHemmaMal(int hemmaMal) {
        this.hemmaMal = hemmaMal;
    }

    public int getBortaMal() {
        return bortaMal;
    }

    public void setBortaMal(int bortaMal) {
        this.bortaMal = bortaMal;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String date) {
        this.datum = date;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String time) {
        this.tid = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrupp() {
        return grupp;
    }

    public void setGrupp(String group) {
        this.grupp = group;
    }

    public Set<MatchTips> getMatchTipsSet() {
        return matchTipsSet;
    }

    public void setMatchTipsSet(Set<MatchTips> matchTipsSet) {
        this.matchTipsSet = matchTipsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matchen matchen = (Matchen) o;

        if (hemmaMal != matchen.hemmaMal) return false;
        if (bortaMal != matchen.bortaMal) return false;
        if (played != matchen.played) return false;
        if (!Objects.equals(id, matchen.id)) return false;
        if (!Objects.equals(datum, matchen.datum)) return false;
        if (!Objects.equals(tid, matchen.tid)) return false;
        if (!Objects.equals(location, matchen.location)) return false;
        if (!Objects.equals(grupp, matchen.grupp)) return false;
        if (!Objects.equals(hemmaLag, matchen.hemmaLag)) return false;
        if (!Objects.equals(bortaLag, matchen.bortaLag)) return false;
        return Objects.equals(matchTipsSet, matchen.matchTipsSet);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (grupp != null ? grupp.hashCode() : 0);
        result = 31 * result + (hemmaLag != null ? hemmaLag.hashCode() : 0);
        result = 31 * result + (bortaLag != null ? bortaLag.hashCode() : 0);
        result = 31 * result + (hemmaMal != null ? hemmaMal.hashCode() : 0);
        result = 31 * result + (bortaMal != null ? bortaMal.hashCode() : 0);
        result = 31 * result + (played ? 1 : 0);
        result = 31 * result + (matchTipsSet != null ? matchTipsSet.hashCode() : 0);
        return result;
    }
}
