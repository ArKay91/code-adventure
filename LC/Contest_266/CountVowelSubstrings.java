package LC.Contest_266;

import java.util.*;

public class CountVowelSubstrings {
    
    public static void main(String[] args) {

    }

    public int countVowelSubstrings(String word) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u'), curr = new HashSet<>();
        int r = 0;
        char[] w = word.toCharArray();
        for(int i=0; i<w.length; i++) {
            for(int j=i; j<w.length && vowels.contains(w[j]); j++) {
                curr.add(w[j]);
                r += curr.size() == vowels.size() ? 1 : 0;
            }
        }

        return r;
    }
}
