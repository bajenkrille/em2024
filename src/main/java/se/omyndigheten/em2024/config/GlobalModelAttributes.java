package se.omyndigheten.em2024.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Krille on 12/06/2024 11:57
 */
@ControllerAdvice
public class GlobalModelAttributes {

    private final boolean external;

    @Autowired
    public GlobalModelAttributes(boolean external) {
        this.external = external;
    }

    @ModelAttribute("external")
    public boolean addExternalToModel() {
        return external;
    }
}