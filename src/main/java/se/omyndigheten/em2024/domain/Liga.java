package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

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
    @OneToMany(mappedBy = "liga")
    private Set<Deltagare> deltagareSet;

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
        result = 31 * result + (deltagareSet != null ? deltagareSet.hashCode() : 0);
        return result;
    }
}
