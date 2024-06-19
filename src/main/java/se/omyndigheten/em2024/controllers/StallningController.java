package se.omyndigheten.em2024.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.omyndigheten.em2024.domain.Liga;
import se.omyndigheten.em2024.services.*;

import java.util.*;


/**
 * Created by Krille on 17/05/2024 17:22
 */
@Controller
public class StallningController {
    private StallningService stallningService;
    private FileService fileService;
    private Map<String,Integer> pointsForDeltagare = new HashMap<>();
    private static final String STALLNING_ALLA = "stallningAlla";

    public StallningController(MatchenService matchenService, StallningService stallningService, FileService fileService) {
        this.stallningService = stallningService;
        this.fileService = fileService;
    }

    private void writeStallningToFile(Map<String,Integer> pointsDeltagareMap){
        List<String> stringList = new ArrayList<>();
        Set<String> mapKeys = pointsDeltagareMap.keySet();
        for (String key:mapKeys) {
            String line = key + "," + pointsDeltagareMap.get(key);
            stringList.add(line);
        }
        if (fileService.doesFileExist(STALLNING_ALLA)){
            fileService.deleteExistingFile(STALLNING_ALLA);
        }
        fileService.writeFile(stringList, STALLNING_ALLA);
    }
    private Map<String, Integer> readStallningFromFile(){
        Map<String, Integer> stallningMap = new HashMap<>();
        List<String> stallningList = fileService.readFromFile(STALLNING_ALLA);
        for (String line:stallningList) {
            String[] splitLine = line.split(",");
            List<String> stringList = new ArrayList<>(Arrays.asList(splitLine));
            stallningMap.put(splitLine[0], Integer.valueOf(splitLine[1]));
        }
        return stallningMap;
    }

    @RequestMapping("/points")
    public String setPoints(Model model){
        stallningService.savePointsForAllDeltagareAndMatches();
        return "points";
    }

    @RequestMapping("/update")
    public String getUpdatedStallning(Model model){
        pointsForDeltagare = stallningService.getPointsForDeltagare();
        writeStallningToFile(pointsForDeltagare);
        model.addAttribute("poangMap",pointsForDeltagare);
        return "stallning";
    }

    @RequestMapping("/stallning")
    public String getStallning(Model model){
        if (fileService.doesFileExist(STALLNING_ALLA)){
            pointsForDeltagare = readStallningFromFile();
        } else {
            pointsForDeltagare = stallningService.getPointsForDeltagare();
        }
        writeStallningToFile(pointsForDeltagare);
        model.addAttribute("poangMap",pointsForDeltagare);
        return "stallning";
    }
}
