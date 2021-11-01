package AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode;

import java.io.File;
import java.util.logging.Logger;

import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.AOCChallangeManager;
import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.days.day2.Day2PasswordPhilosophy_1;
import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.days.day2.Day2PasswordPhilosophy_2;
import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.days.day3.Day3TobogganTrajectory_1;
import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.days.day3.Day3TobogganTrajectory_2;

import java.util.logging.Level;

public class AdventOfCode2020 {
    public static final Logger LOGGER = Logger.getLogger(AdventOfCode2020.class.getName());

    public static void main(String[] args) {
        LOGGER.setLevel(Level.INFO);

        AOCChallangeManager aocChallangeManager = new AOCChallangeManager();
        aocChallangeManager.addAOCChallange(new Day2PasswordPhilosophy_1("day2_1", 
                    new File("AdventOfCode/AdventOfCode2020/src/main/resources/data/day_2.txt")));
        aocChallangeManager.addAOCChallange(new Day2PasswordPhilosophy_2("day2_2", 
                    new File("AdventOfCode/AdventOfCode2020/src/main/resources/data/day_2.txt")));
        aocChallangeManager.addAOCChallange(new Day3TobogganTrajectory_1("day3_1", 
                    new File("AdventOfCode/AdventOfCode2020/src/main/resources/data/day_3.txt")));
        aocChallangeManager.addAOCChallange(new Day3TobogganTrajectory_2("day3_2", 
                    new File("AdventOfCode/AdventOfCode2020/src/main/resources/data/day_3.txt")));

        aocChallangeManager.runAOCChallange("day2_1");
        aocChallangeManager.runAOCChallange("day2_2");
        aocChallangeManager.runAOCChallange("day3_1");
        aocChallangeManager.runAOCChallange("day3_2");
    }

}
