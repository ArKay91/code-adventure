package AdventOfCode.Day2PasswordPhilosophy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day2PasswordPhilosophy {
    
    public static void main(String[] args) {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("AdventOfCode/Day2PasswordPhilosophy/input.txt"));
            List<String> passwordPolicies = new ArrayList<>();
            String policyLine = bufReader.readLine();
            while(policyLine != null) {
                passwordPolicies.add(policyLine);
                policyLine = bufReader.readLine();
            }
            bufReader.close();
            System.out.println("Number of valid password found are : " +howManyPasswordsAreValid(passwordPolicies));
            System.out.println("Number of valid password found are : " +howManyPasswordsAreValidOnIndex(passwordPolicies));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int howManyPasswordsAreValid(List<String> passwords) {
        int count = 0;
        for(String password : passwords) {
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
            if(tempCount >= low && tempCount <= high) count++;
        }
        return count;
    }

    public static int howManyPasswordsAreValidOnIndex(List<String> passwords) {
        int count = 0;
        for(String password : passwords) {
            //5-9 g: ggccggmgn
            String[] passwordSplit = password.split(" ");
            int oneIndex = Integer.parseInt(passwordSplit[0].split("-")[0]);
            int twoIndex = Integer.parseInt(passwordSplit[0].split("-")[1]);
            char charToVerify = passwordSplit[1].charAt(0);

            String passToVerify = passwordSplit[2];
            
            char oneIndexChar = passToVerify.charAt(oneIndex-1);
            char twoIndexChar = passToVerify.charAt(twoIndex-1);

            if((oneIndexChar != charToVerify && twoIndexChar != charToVerify) || 
                (oneIndexChar == charToVerify && twoIndexChar == charToVerify)) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }
}
