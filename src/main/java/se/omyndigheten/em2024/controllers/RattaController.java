package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.omyndigheten.em2024.commands.DeltagareCommand;
import se.omyndigheten.em2024.domain.MatchTips;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.services.DeltagareService;
import se.omyndigheten.em2024.services.RattaService;

import java.util.List;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class RattaController {

    private final RattaService rattaService;

    public RattaController(RattaService rattaService) {
        this.rattaService = rattaService;
    }

    public static class MatchListWrapper {
        private List<Matchen> matchList;
        public List<Matchen> getMatchList() {
            return matchList;
        }
        public void setMatchList(List<Matchen> matchList) {
            this.matchList = matchList;
        }
    }

    @GetMapping("/ratta")
    public String rattaGet(Model model) {
        MatchListWrapper wrapper = new MatchListWrapper();
        wrapper.setMatchList(rattaService.getAllMatches());
        model.addAttribute("matchenList",wrapper);
        return "ratta";
    }

    @PostMapping("/rattad")
    public String rattaSubmit(@ModelAttribute MatchListWrapper matchListWrapper, Model model) {
        model.addAttribute("matchenlist", matchListWrapper);

        //rattaService.saveRattadMatch(matchen);
        return "ratta";
    }
}
