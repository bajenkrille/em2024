package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.omyndigheten.em2024.commands.DeltagareCommand;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.services.DeltagareService;
import se.omyndigheten.em2024.services.RattaService;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class RattaController {

    private final RattaService rattaService;

    public RattaController(RattaService rattaService) {
        this.rattaService = rattaService;
    }

    @GetMapping("/ratta")
    public String rattaGet(Model model) {
        model.addAttribute("matchenList", rattaService.getAllMatches());
        return "ratta";
    }

    @PostMapping("/ratta")
    public String anmalanSubmit(@ModelAttribute Matchen matchen, Model model) {
        model.addAttribute("matchen", matchen);

        rattaService.saveRattadMatch(matchen);
        return "ratta";
    }
}
