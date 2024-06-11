package se.omyndigheten.em2024.commands;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Krille on 10/06/2024 19:42
 */
public class TipsCommand {
    @NotEmpty
    @Digits(integer = 2, fraction = 0)
    private Integer hemmaMal;
    @NotEmpty
    @Digits(integer = 2, fraction = 0)
    private Integer bortaMal;

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
}
