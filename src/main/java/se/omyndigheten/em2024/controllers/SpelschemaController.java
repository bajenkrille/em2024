package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.services.TipsService;

import java.util.List;

/**
 * Created by Krille on 14/06/2024 13:53
 */
@Controller
public class SpelschemaController {

    private TipsService tipsService;

    public SpelschemaController(TipsService tipsService) {
        this.tipsService = tipsService;
    }

    @RequestMapping("spelschema")
    public String getSpelschema(Model model){
        List<Matchen> matchenList = tipsService.getAllMatches();
        model.addAttribute("matcherna", matchenList);
        return "spelschema";
    }
}
