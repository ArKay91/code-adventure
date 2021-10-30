package FB_Excercise.Strings;

public class RotationalCipher {
    

  // Add any helper functions you may need here

  public static void main(String[] args) {
    System.out.println("Cipher for Zebra-493 is : " + rotationalCipher("Zebra-493", 3));
  }
  

  static String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    
    char[] inputChars = input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<inputChars.length; i++) {
      char temp = inputChars[i];

      if(Character.isDigit(temp)) {
        sb.append((Character.getNumericValue(temp) + rotationFactor) % 10);
        continue;
      } else if(Character.isLetter(temp)) {
        if(Character.isUpperCase(temp)) {
            int originalAlphabetPosition = temp - 'A';
            int newAlphabetPosition = (originalAlphabetPosition + rotationFactor) % 26;
            sb.append((char) ('A' + newAlphabetPosition));    
            continue;
        }
        else {
            int originalAlphabetPosition = temp - 'a';
            int newAlphabetPosition = (originalAlphabetPosition + rotationFactor) % 26;
            sb.append((char) ('a' + newAlphabetPosition));
            continue;
        }
      }
      sb.append(temp);
    }
    
    return sb.toString();
  }










//   // These are the tests we use to determine if the solution is correct.
//   // You can add your own at the bottom.
//   int test_case_number = 1;
//   void check(String expected, String output) {
//     boolean result = (expected.equals(output));
//     char rightTick = '\u2713';
//     char wrongTick = '\u2717';
//     if (result) {
//       System.out.println(rightTick + " Test #" + test_case_number);
//     }
//     else {
//       System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
//       printString(expected); 
//       System.out.print(" Your output: ");
//       printString(output);
//       System.out.println();
//     }
//     test_case_number++;
//   }
//   void printString(String str) {
//     System.out.print("[\"" + str + "\"]");
//   }
  
//   public void run() {
//     String input_1 = "All-convoYs-9-be:Alert1.";
//     int rotationFactor_1 = 4;
//     String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
//     String output_1 = rotationalCipher(input_1, rotationFactor_1);
//     check(expected_1, output_1);

//     String input_2 = "abcdZXYzxy-999.@";
//     int rotationFactor_2 = 200;
//     String expected_2 = "stuvRPQrpq-999.@";
//     String output_2 = rotationalCipher(input_2, rotationFactor_2);
//     check(expected_2, output_2);

//     // Add your own test cases here
//   }
}