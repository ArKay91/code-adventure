package AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.days.day3;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.AdventOfCode2020;
import AdventOfCode.AdventOfCode2020.src.main.java.aarkay.adventofcode.aocchallanges.AOCChallange;

public class Day3TobogganTrajectory_2 extends AOCChallange {
    
    private double matches = 1.0;

    public Day3TobogganTrajectory_2(String key, File data) {
        super(key, data);
    }

    @Override
    public void run() {
        List<String> map = super.getLines();
        int[][] slopes = new int[][] {{1,1}, {1, 3}, {1, 5}, {1, 7}, {2, 1}};
        
        for(int[] slope : slopes) {
            matches *= treeFindersWithSlope(slope, map);
        }

        AdventOfCode2020.LOGGER.log(Level.INFO, "{0}", matches);
    }

    private int treeFindersWithSlope(int[] slope, List<String> map) {
        int r = slope[0];
        int c = slope[1];
        int tempMatches = 0;

        while(r < map.size()) {
            if(map.get(r).charAt(c) == '#') tempMatches++;
            r += slope[0];
            c += slope[1];
            if(r < map.size())
                c %= map.get(r).length();
            else
                break;
        }

        return tempMatches;
    }
} 
