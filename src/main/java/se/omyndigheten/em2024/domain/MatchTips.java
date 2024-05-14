package se.omyndigheten.em2024.domain;

import jakarta.persistence.*;

/**
 * Created by Krille on 01/05/2024 19:56
 */
@Entity
public class MatchTips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchTipsId;
    private int hemmaMal;
    private int bortaMal;
    @ManyToOne
    private Deltagare deltagare;

    public void setMatchTipsId(Long id) {
        this.matchTipsId = id;
    }

    public Long getMatchTipsId() {
        return matchTipsId;
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
}
