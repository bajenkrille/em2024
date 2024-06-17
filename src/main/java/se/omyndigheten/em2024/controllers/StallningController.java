package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.services.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Krille on 17/05/2024 17:22
 */
@Controller
public class StallningController {
    private StallningService stallningService;

    public StallningController(MatchenService matchenService, StallningService stallningService) {
       this.stallningService = stallningService;
    }
    @RequestMapping("/points")
    public String setPoints(Model model){
        stallningService.savePointsForAllDeltagareAndMatches();
        return "points";
    }

    @RequestMapping("/stallning")
    public String getStallning(Model model){
        Map<String,Integer> pointsForDeltagare = stallningService.getPointsForDeltagare();
        model.addAttribute("poangMap",pointsForDeltagare);
        return "stallning";
    }
}
