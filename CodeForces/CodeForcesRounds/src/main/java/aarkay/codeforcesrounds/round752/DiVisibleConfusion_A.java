package CodeForces.CodeForcesRounds.src.main.java.aarkay.codeforcesrounds.round752;

import java.io.*;
import java.util.*;
 
 
public class DiVisibleConfusion_A {
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      

      // Start writing your solution here. -------------------------------------
   
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

    int totalCases = sc.nextInt();
    
    while(totalCases != 0) {
        int inputCount = sc.nextInt();
        List<Integer> input = new ArrayList<>();
        int i = 0;
        while(i != inputCount) {
            input.add(sc.nextInt());
            i++;
        }
        out.println(findDivisibilityConfusionForInput(input));
        totalCases--;
    }


      // Stop writing your solution here. -------------------------------------
      out.close();
   }

   private static String findDivisibilityConfusionForInput(List<Integer> testCase) {
        for(int i=0; i<testCase.size(); i++) {
            int temp = testCase.get(i);
            if(temp % (i+2) != 0) {
                continue;
            } else {
                boolean validFlag = false;
                for(int j = i-1; j>=0; j--) {
                    if(temp % (j+2) != 0) {
                        validFlag = true;
                        break;
                    }
                }
                if(!validFlag) return "NO";
            }
        }
        return "YES";
    }

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
   //--------------------------------------------------------
}
