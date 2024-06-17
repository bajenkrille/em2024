package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.omyndigheten.em2024.domain.Deltagare;
import se.omyndigheten.em2024.domain.Liga;
import se.omyndigheten.em2024.services.DeltagareService;
import se.omyndigheten.em2024.services.LigaService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class LigaController {

    private DeltagareService deltagareService;
    private LigaService ligaService;

    public LigaController(DeltagareService deltagareService, LigaService ligaService) {
        this.deltagareService = deltagareService;
        this.ligaService = ligaService;
    }

    @GetMapping("/visaligor")
    public String getLigor(Model model){
        List<Liga> allaLigor = ligaService.findAllaLigor();
        model.addAttribute("allaLigor",allaLigor);
        return "visaligor";
    }

    @PostMapping("visaligor")
    public String showLigor(Model model, @RequestParam(name = "liga") String liga){
        Map<Deltagare, Integer> deltagareIntegerMap = ligaService.getLigaDeltagarePointsMap(liga);
        model.addAttribute("deltagarePointsMap", deltagareIntegerMap);
        model.addAttribute("liga", liga);
        return "ligastallning";
    }

    @GetMapping("/liga")
    public String ligaGet(Model model) {
        List<Deltagare> deltagareList = deltagareService.getAllaDeltagare();
        String ligaNamn = "";
        String beskrivning = "";
        model.addAttribute("ligaNamn", ligaNamn);
        model.addAttribute("beskrivning", beskrivning);
        model.addAttribute("deltagare", deltagareList);
        return "liga";
    }

    @PostMapping("/liga")
    public String ligaSkapa(@RequestParam(name = "selectedDeltagare", required = false) List<Long> selectedDeltagareIds,
                            @RequestParam(name = "ligaNamn") String ligaNamn,
                            @RequestParam(name = "beskrivning") String beskrivning, Model model) {
        // Process the selected deltagare IDs here
        Set<Deltagare> deltagareSet = new HashSet<>();
        if (selectedDeltagareIds != null) {
            for (long deltagareId:selectedDeltagareIds) {
                Deltagare deltagare = deltagareService.getDeltagareById(deltagareId);
                deltagareSet.add(deltagare);
            }
        } else {
            // No deltagare were selected
        }
        ligaService.skapaLiga(ligaNamn,beskrivning,deltagareSet);
        return "redirect:/liga";
    }

}
