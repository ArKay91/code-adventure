package AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AOCChallange {
    private String key;
    private File data;

    protected AOCChallange(String key, File data) {
        this.key = key;
        this.data = data;
    }

    public abstract void run();

    public String getKey() {
        return key;
    }

    public File getData() {
        return data;
    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
