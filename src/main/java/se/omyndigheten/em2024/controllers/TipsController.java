package se.omyndigheten.em2024.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.services.DeltagareService;
import se.omyndigheten.em2024.services.MatchTipsService;
import se.omyndigheten.em2024.services.TipsService;

import java.util.List;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class TipsController {

    private final TipsService tipsService;
    private final DeltagareService deltagareService;
    private final MatchTipsService matchTipsService;

    public TipsController(TipsService tipsService, DeltagareService deltagareService, MatchTipsService matchTipsService) {
        this.tipsService = tipsService;
        this.deltagareService = deltagareService;
        this.matchTipsService = matchTipsService;
    }
    public static class MatchTipsListWrapper {
        private List<MatchTips> matchTipsList;

        public List<MatchTips> getMatchTipsList() {
            return matchTipsList;
        }

        public void setMatchTipsList(List<MatchTips> matchTipsList) {
            this.matchTipsList = matchTipsList;
        }
    }

    @GetMapping("/matchtips")
    public String matchTipsGet(@RequestParam("deltagareId") Long deltagareId, Model model) {
        Deltagare deltagare = deltagareService.getDeltagareById(deltagareId);
        model.addAttribute("deltagare", deltagare);

        MatchTipsListWrapper wrapper = new MatchTipsListWrapper();
        wrapper.setMatchTipsList(matchTipsService.getMatchTipsList());
        model.addAttribute("matchTipsWrapper", wrapper);
        return "matchtips";
    }

    @PostMapping("/matchtips")
    public String matchTipsSubmit(@ModelAttribute MatchTipsListWrapper matchTipsWrapper, @RequestParam("deltagareId") Long deltagareId, Model model, HttpSession session) {
        model.addAttribute("matchtips", matchTipsWrapper.getMatchTipsList());
        Deltagare deltagare = deltagareService.getDeltagareById(deltagareId);
        matchTipsService.saveMatchTips(matchTipsWrapper.getMatchTipsList(), deltagare);
        model.addAttribute("deltagare", deltagare);
        return "matchtips3";
    }

    //@RequestMapping("/matchtips")
    public String getTips(Model model){
        model.addAttribute("matches", tipsService.getAllMatches());
        return "matchtips2";
    }

    //@GetMapping("/matchtips")
//    public String matchTipsGet(Model model) {
//        model.addAttribute("matchtips", matchTipsService.getMatchTipsList());
//        return "matchtips";
//    }

    //@PostMapping("/matchtips")
    public String matchTipsSubmit(@ModelAttribute List<MatchTips> matchTipsList, Model model) {
        model.addAttribute("matchtips", matchTipsList);
        matchTipsService.saveMatchTips(matchTipsList);
        return "matchtips";
    }

}
