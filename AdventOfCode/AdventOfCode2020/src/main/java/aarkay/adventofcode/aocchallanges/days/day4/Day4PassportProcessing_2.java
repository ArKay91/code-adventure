package AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.days.day4;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.Arrays;

import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.AdventOfCode2020;
import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.AOCChallange;

public class Day4PassportProcessing_2 extends AOCChallange {
    private static final List<String> validKeys = Arrays.asList("hcl", "iyr", "hgt", "pid", "byr", "eyr", "ecl");

    private int validPassports = 0;
    StringBuilder input = new StringBuilder();

    public Day4PassportProcessing_2(String key, File data) {
        super(key, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(s -> input.append(s).append(System.lineSeparator()));
        
        Arrays.stream(input.toString().split(System.lineSeparator() + System.lineSeparator())).forEach(s -> {
            s = s.replace(System.lineSeparator(), " ");
            Map<String, String> passportFields = Arrays.stream(s.split(" ")).map(keyValue -> keyValue.split(":")).collect(Collectors.toMap(o -> o[0], o -> o[1]));
            if(isValid(passportFields)) validPassports++;
        });
        AdventOfCode2020.LOGGER.log(Level.INFO, "{0}", validPassports);
    }

    private boolean isValid(Map<String, String> data) {
        if(!data.keySet().containsAll(validKeys)) return false;

        if(!data.get("byr").matches("^(200[0-2]|19[2-9][0-9])$")) return false;
        if(!data.get("iyr").matches("^(2020|201[0-9])$")) return false;
        if(!data.get("eyr").matches("^(2030|202[0-9])$")) return false;
        if(!data.get("hgt").matches("^((1([5-8][0-9]|9[0-3])cm)|((59|6[0-9]|7[0-6])in))$")) return false;
        if(!data.get("hcl").matches("^(#[0-9a-f]{6})$")) return false;
        if(!data.get("ecl").matches("^(amb|blu|brn|gry|grn|hzl|oth)$")) return false;
        if(!data.get("pid").matches("^([0-9]{9})$")) return false;

        return true;
    }
}
