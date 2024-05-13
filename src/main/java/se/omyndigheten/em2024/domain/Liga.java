package se.omyndigheten.em2024.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Created by Krille on 01/05/2024 19:46
 */
@Entity
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long deltagareId;
    private String ligansName;
    private String description;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLigansName() {
        return ligansName;
    }

    public void setLigansName(String ligansNamn) {
        this.ligansName = ligansNamn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String beskrivning) {
        this.description = beskrivning;
    }
}
