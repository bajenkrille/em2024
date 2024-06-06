package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.services.DeltagareService;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class DeltagareController {

    private final DeltagareService deltagareService;

    public DeltagareController(DeltagareService deltagareService) {
        this.deltagareService = deltagareService;
    }

    @GetMapping("/deltagare")
    public String anmalanGet(Model model) {
        model.addAttribute("deltagare", new Deltagare());
        return "deltagare";
    }

    @PostMapping("/deltagare")
    public String anmalanSubmit(@ModelAttribute Deltagare deltagare, Model model) {
        model.addAttribute("deltagare", deltagare);
        deltagareService.saveDeltagare(deltagare);
        Long id = deltagare.getId();
        return "redirect:/matchtips?deltagareId=" + deltagare.getId();
    }
}
