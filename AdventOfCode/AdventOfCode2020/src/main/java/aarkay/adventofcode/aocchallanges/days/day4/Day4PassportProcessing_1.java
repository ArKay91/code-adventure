package AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.days.day4;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.Arrays;

import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.AdventOfCode2020;
import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.AOCChallange;

public class Day4PassportProcessing_1 extends AOCChallange {
    
    private static final List<String> validKeys = Arrays.asList("hcl", "iyr", "hgt", "pid", "byr", "eyr", "ecl");
    private int validPassports = 0;
    StringBuilder fullData = new StringBuilder();

    public Day4PassportProcessing_1(String key, File data) {
        super(key, data);
    }

    @Override
    public void run() {

        super.getLines().forEach(s -> fullData.append(s).append(System.lineSeparator()));

        Arrays.stream(fullData.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> {
            s = s.replace(System.lineSeparator(), " ");
            Map<String, String> passData = Arrays.stream(s.split(" ")).map(keyValue -> keyValue.split(":")).collect(Collectors.toMap(o -> o[0], o -> o[1]));
            if(isValid(passData)) validPassports++;
        });

        AdventOfCode2020.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    public boolean isValid(Map<String, String> data) {
        return data.keySet().containsAll(validKeys);
    }
}
