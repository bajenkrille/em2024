package se.omyndigheten.em2024.services;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import se.omyndigheten.em2024.domain.MatchTips;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krille on 09/06/2024 19:37
 */
@Component
public class FileService {
    String filePath;
    List<String> lines = new ArrayList<>();
    @Value("${pathtotips}")
    private String path;

    public FileService() {
    }

    public void writeFile(List<String> stringList, String s) {
        filePath = path + s + ".txt";
        try {
            Files.write(Paths.get(filePath), stringList, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ett fel uppstod.");
            e.printStackTrace();
        }
    }
    public void writeTipsToFile(List<MatchTips> matchTipsList, String s) {
        for (MatchTips matchTips:matchTipsList){
            String hemmaLag = matchTips.getMatchen().getHemmaLag();
            String bortaLag = matchTips.getMatchen().getBortaLag();
            Integer hemmaMal = matchTips.getHemmaMal();
            Integer bortaMal = matchTips.getBortaMal();
            String line = hemmaLag + " - " + bortaLag + "\t" + hemmaMal + " - " + bortaMal;
            lines.add(line);
        }

        filePath = path + s + ".txt";

        try {
            Files.write(Paths.get(filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Ett fel uppstod.");
            e.printStackTrace();
        }
    }
    public List<String> readFromFile(String fileName){
        List<String> textFile = new ArrayList<>();
        filePath = path + fileName + ".txt";
        try {
            textFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textFile;
    }

    public boolean doesFileExist(String fileName){
        filePath = path + fileName + ".txt";
        return Files.exists(Paths.get(filePath));
    }
    public void deleteExistingFile(String fileName){
        filePath = path + fileName + ".txt";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
