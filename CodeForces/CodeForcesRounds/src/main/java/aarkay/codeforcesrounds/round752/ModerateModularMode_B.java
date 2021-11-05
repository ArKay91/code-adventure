//package CodeForces.CodeForcesRounds.src.main.java.aarkay.codeforcesrounds.round752;

import java.io.*;
import java.util.*;

public class ModerateModularMode_B {
    
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
            int x = sc.nextInt();
            int y = sc.nextInt();
            out.println(findModerateModularForInput(x, y));
            totalCases--;
        }
    
        // Stop writing your solution here. -------------------------------------
        out.close();
    }

    // private static long findModerateModularForInput(long x, long y) {
    //     int i = 1, j = 1; // 
    //     long numerator = ((x * i) + y);
    //     long denominator = (j + 1);
    //     long n = (numerator / denominator);
    //     while(true) {
    //         for(;; i++) {
    //             for(j=i;j>0;j-=1) {
    //                 numerator = ((x * i) + y);
    //                 denominator = (j + 1);
    //                 n = (numerator / denominator);
    //                 //System.out.println("i : " + i + " j : " + j + " n : " + n);
    //                 if((n % 1 == 0) && ((n % x) == (y % n))) {
    //                     //System.out.println("ANS to this "+"i : " + i + " j : " + j + " n : " + n);
    //                     return n;
    //                 }
    //             }
    //         }
    //     }
    // }

    private static int findModerateModularForInput(int x, int y) {
        if(x == y) return x;
        else if(y < x) return x+y;
        else {
            int d = y%x;
            return (y-d/2);
        }
    }

    //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;

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
