package AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.days.day3;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.AdventOfCode2020;
import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.AOCChallange;

public class Day3TobogganTrajectory_1 extends AOCChallange {
    
    private int matches = 0;
    
    public Day3TobogganTrajectory_1(String key, File data) {
        super(key, data);
    }

    @Override
    public void run() {
        List<String> map = super.getLines();
        int r = 1;
        int c = 3;
        while(r < map.size()) {
            if(map.get(r).charAt(c) == '#') matches++;
            r++;
            c += 3;
            if(r < map.size())
                c %= map.get(r).length();
            else
                break;
        }
        AdventOfCode2020.LOGGER.log(Level.INFO, "{0}", matches);
    }
}
