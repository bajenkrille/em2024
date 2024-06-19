package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.omyndigheten.em2024.domain.Matchen;
import se.omyndigheten.em2024.services.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Krille on 17/05/2024 17:21
 */
@Controller
public class TipsController {

    private final TipsService tipsService;
    private final MatchTipsService matchTipsService;
    private final FileService fileService;
    private final MatchenService matchenService;
    private List<Matchen> matchenList;
    private Map<Long, List<String>> tipsMap;
    private static final int PAGE_SIZE = 20;
    private static final String ALLAS_TIPS = "allasTips";

    public TipsController(DeltagareService deltagareService, TipsService tipsService, MatchTipsService matchTipsService, FileService fileService, MatchenService matchenService) {
        this.tipsService = tipsService;
        this.matchTipsService = matchTipsService;
        this.fileService = fileService;
        this.matchenService = matchenService;
    }

    private void writeTipsToFile(List<Matchen> matchenList, Map<Long, List<String>> tipsMap){
        List<String> stringList = new ArrayList<>();

        String line = "Match";
        List<String> nickNames = tipsMap.get(0L);
        for (String nickName:nickNames) {
            line += "," + nickName;
        }
        stringList.add(line);
        for (long i = 1;i <= 36;i++){
            List<String> tempList = tipsMap.get(i);
            int j = (int) i;
            line = matchenList.get(j-1).getHemmaLag() + " - " + matchenList.get(j-1).getBortaLag();
            for (String tips:tempList) {
                line += "," + tips;
            }
            stringList.add(line);
        }
        fileService.writeFile(stringList, ALLAS_TIPS);
    }

    private void readTipsFromFile(){
        tipsMap = new HashMap<>();
        matchenList = new ArrayList<>();
        List<String> tipsFile = fileService.readFromFile(ALLAS_TIPS);
        int i = 0;
        for (String line:tipsFile) {
            long j = (long) i;
            String[] splitLine = line.split(",");
            List<String> stringList = new ArrayList<>(Arrays.asList(splitLine));
            stringList.remove(0); //Ta bort kolumnen med matcher
            if (i != 0) {
                matchenList.add(matchenService.getMatchFromId(j));
            }
            tipsMap.put(j,stringList);
            i++;
        }
    }

    @RequestMapping("/tips")
    public String tipsGet(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {

        if (fileService.doesFileExist(ALLAS_TIPS)){
            readTipsFromFile();
        } else {
            matchenList = tipsService.getAllMatches();
            tipsMap = matchTipsService.getListOfDeltagareAndTips();
        }
        //writeTipsToFile(matchenList,tipsMap);
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
