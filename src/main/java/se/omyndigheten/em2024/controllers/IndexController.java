package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Krille on 17/05/2024 17:20
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

}
