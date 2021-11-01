package AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.days.day2;

import java.io.File;
import java.util.logging.Level;

import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.AdventOfCode2020;
import AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges.AOCChallange;

public class Day2PasswordPhilosophy_2 extends AOCChallange {
    
    private int matches = 0;

    public Day2PasswordPhilosophy_2(String id, File data) {
        super(id, data);
    }

    @Override
    public void run() {
        super.getLines().forEach(password -> {
                //5-9 g: ggccggmgn
                String[] passwordSplit = password.split(" ");
                int oneIndex = Integer.parseInt(passwordSplit[0].split("-")[0]);
                int twoIndex = Integer.parseInt(passwordSplit[0].split("-")[1]);
                char charToVerify = passwordSplit[1].charAt(0);
    
                String passToVerify = passwordSplit[2];
                
                char oneIndexChar = passToVerify.charAt(oneIndex-1);
                char twoIndexChar = passToVerify.charAt(twoIndex-1);
    
                if((oneIndexChar != charToVerify && twoIndexChar == charToVerify) || 
                    (oneIndexChar == charToVerify && twoIndexChar != charToVerify)) {
                    matches++;
                }
        });
        AdventOfCode2020.LOGGER.log(Level.INFO, "{0}", matches);
    }
}
