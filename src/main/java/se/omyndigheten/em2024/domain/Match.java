package se.omyndigheten.em2024.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Created by Krille on 01/05/2024 19:52
 */
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hemmaLag;
    private String bortaLag;
    private int hemmaMal;
    private int bortaMal;
    private boolean played;

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

}
