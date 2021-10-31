package AdventOfCode.AdventOfCode2020.src.main.java.krayanki.adventofcode.aocchallanges;

import java.util.ArrayList;
import java.util.List;

public class AOCChallangeManager {
    private List<AOCChallange> aocChallangeList;

    public AOCChallangeManager() {
        this.aocChallangeList = new ArrayList<>();
    }

    public void addAOCChallange(AOCChallange aocChallange) {
        this.aocChallangeList.add(aocChallange);
    }

    public void runAOCChallange(String id) {
        this.aocChallangeList.stream().filter(aocChallange -> aocChallange.getKey().equals(id)).forEach(AOCChallange::run);
    }
}
