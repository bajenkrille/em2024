package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Krille on 01/05/2024 19:46
 */
@Entity
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ligaName;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "liga_deltagare",
            joinColumns = @JoinColumn(name = "liga_id"),
            inverseJoinColumns = @JoinColumn(name = "deltagare_id")
    )
    private Set<Deltagare> deltagareSet = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLigaName() {
        return ligaName;
    }

    public void setLigaName(String ligaName) {
        this.ligaName = ligaName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String beskrivning) {
        this.description = beskrivning;
    }

    public Set<Deltagare> getDeltagareSet() {
        return deltagareSet;
    }

    public void setDeltagareSet(Set<Deltagare> deltagareSet) {
        this.deltagareSet = deltagareSet;
    }

    public void addDeltagare(Deltagare deltagare) {
        this.deltagareSet.add(deltagare);
        deltagare.getLigaSet().add(this);
    }

    public void removeDeltagare(Deltagare deltagare) {
        this.deltagareSet.remove(deltagare);
        deltagare.getLigaSet().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Liga liga = (Liga) o;

        if (!Objects.equals(id, liga.id)) return false;
        if (!Objects.equals(ligaName, liga.ligaName)) return false;
        if (!Objects.equals(description, liga.description)) return false;
        return Objects.equals(deltagareSet, liga.deltagareSet);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ligaName != null ? ligaName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
