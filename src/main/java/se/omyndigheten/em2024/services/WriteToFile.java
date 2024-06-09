package se.omyndigheten.em2024.services;

import se.omyndigheten.em2024.domain.MatchTips;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Krille on 09/06/2024 19:37
 */
public class WriteToFile {
    String filePath;
    List<String> lines = new ArrayList<>();

    public WriteToFile(String s) {
        filePath = "src/main/resources/tipsfiler/" + s + ".txt";
    }

    public void writeFile(String line) {
        List<String> lines = Arrays.asList(line);
        try {
            Files.write(Paths.get(filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ett fel uppstod.");
            e.printStackTrace();
        }
    }
    public void writeTipsToFile(List<MatchTips> matchTipsList) {
        for (MatchTips matchTips:matchTipsList){
            String hemmaLag = matchTips.getMatchen().getHemmaLag();
            String bortaLag = matchTips.getMatchen().getBortaLag();
            Integer hemmaMal = matchTips.getHemmaMal();
            Integer bortaMal = matchTips.getBortaMal();
            String line = hemmaLag + " - " + bortaLag + "\t" + hemmaMal + " - " + bortaMal;
            lines.add(line);
        }

        try {
            Files.write(Paths.get(filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ett fel uppstod.");
            e.printStackTrace();
        }
    }

}
