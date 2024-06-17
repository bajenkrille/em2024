package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.services.DeltagareService;
import se.omyndigheten.em2024.services.MatchTipsService;
import se.omyndigheten.em2024.services.TipsService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class TipsController {

    private final TipsService tipsService;
    private final MatchTipsService matchTipsService;
    private static final int PAGE_SIZE = 20;

    public TipsController(DeltagareService deltagareService, TipsService tipsService, MatchTipsService matchTipsService) {
        this.tipsService = tipsService;
        this.matchTipsService = matchTipsService;
    }

    @RequestMapping("/tips")
    public String tipsGet(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        List<Matchen> matchenList = tipsService.getAllMatches();
        Map<Long, List<String>> tipsMap = matchTipsService.getListOfDeltagareAndTips();
        List<String> nicknames = tipsMap.remove(0L);

        //Pagination
        int totalDeltagare = nicknames.size();
        int totalPages = (int) Math.ceil((double) totalDeltagare / PAGE_SIZE);
        int start = (page - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, totalDeltagare);
        List<String> paginatedNicknames = nicknames.subList(start, end);
        Map<Long, List<String>> paginatedTipsMap = tipsMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().subList(start, end)
                ));

        model.addAttribute("matchenList", matchenList);
        model.addAttribute("tipsMap", paginatedTipsMap);
        model.addAttribute("nicknames", paginatedNicknames);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "tips";
    }
}
