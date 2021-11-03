package AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.days.day2;

import java.io.File;

import java.util.logging.Level;

import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.AdventOfCode2020;
import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.AOCChallange;

public class Day2PasswordPhilosophy_1 extends AOCChallange {
    
    private int matches = 0;

    public Day2PasswordPhilosophy_1(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(password -> {
            //5-9 g: ggccggmgn
            String[] passwordSplit = password.split(" ");
            int low = Integer.parseInt(passwordSplit[0].split("-")[0]);
            int high = Integer.parseInt(passwordSplit[0].split("-")[1]);
            char charToVerify = passwordSplit[1].charAt(0);

            String passToVerify = passwordSplit[2];
            int tempCount = 0;
            for(char c : passToVerify.toCharArray()) {
                if(c == charToVerify) tempCount++;
            }
            if(tempCount >= low && tempCount <= high) matches++;
        });

        AdventOfCode2020.LOGGER.log(Level.INFO, "{0}", matches);
    }
    
}
