package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.services.MatchTipsService;
import se.omyndigheten.em2024.services.TipsService;

import java.util.List;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class TipsController {

    private TipsService tipsService;

    private MatchTipsService matchTipsService;

    public TipsController(TipsService tipsService, MatchTipsService matchTipsService) {
        this.tipsService = tipsService;
        this.matchTipsService = matchTipsService;
    }

    @RequestMapping("/matchtips")
    public String getTips(Model model){
        model.addAttribute("matches", tipsService.getAllMatches());
        return "matchtips2";
    }

    @GetMapping("/matchtips2")
    public String matchTipsGet(Model model) {
        model.addAttribute("matchtips", matchTipsService.getMatchTipsList());
        return "matchtips2";
    }

    @PostMapping("/matchTips2")
    public String matchTipsSubmit(@ModelAttribute List<MatchTips> matchTipsList, Model model) {
        model.addAttribute("matchtips", matchTipsList);
        matchTipsService.saveMatchTips(matchTipsList);
        return "result";
    }

}
