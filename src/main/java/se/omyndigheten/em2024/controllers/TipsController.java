package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.services.MatchTipsService;
import se.omyndigheten.em2024.services.TipsService;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class TipsController {

    private TipsService tipsService;
    private MatchTipsService matchTipsService;

    public TipsController(TipsService tipsService) {
        this.tipsService = tipsService;
    }

    @RequestMapping("matchtips")
    public String getTips(Model model){

        model.addAttribute("matches", tipsService.getAllMatches());
        return null;
    }

    @GetMapping("/matchtips")
    public String matchTipsGet(Model model) {
        model.addAttribute("matchtips", new MatchTips());
        return "matchtips";
    }

    @PostMapping("/matchTips")
    public String matchTipsSubmit(@ModelAttribute MatchTips matchTips, Model model) {
        model.addAttribute("matchtips", matchTips);
        matchTipsService.saveMatchTips(matchTips);
        return "result";
    }

}
