package SampleCodes;

import java.util.*;

public class SubStringsOfString {
    
    List<String> backTrackResult = new ArrayList<>();

    public static void main(String[] args) {
        //List<String> result = printAllSubStringsIterative("aba");
        //for(String word : result) {
        //    System.out.println(word);
        //}
        printAllSubStringsRecursive("aba", 0, 0);
        
    }

    public static List<String> printAllSubStringsIterative(String word) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<word.length(); i++) {
            for(int j=i; j<word.length(); j++) {
                result.add(word.substring(i, j+1));
            }
        }

        return result;
    }


    public static void printAllSubStringsRecursive(String word, int start, int end) {
        if(start == word.length() && end == word.length()) {
            return;
        } else {
            if(end == word.length()+1) {
                printAllSubStringsRecursive(word, start + 1, start + 1);
            } else{
                System.out.println(word.substring(start, end));
                printAllSubStringsRecursive(word, start, end+1);
            }
        }
    }
}
