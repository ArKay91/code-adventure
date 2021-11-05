package CodeForces.CodeForcesRounds.src.main.java.aarkay.codeforcesrounds.round752;

import java.util.*;

public class TestLocally {

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);temp.add(1);temp.add(4);

        long[][] values = new long[][] {
            {1000000000, 1000000000}, 
            {500000000, 1000000000}, 
            {500000000, 500000000},
            {500000000, 1000000000},
            {500000000, 500000000},
            {1000000000, 2},
            {1000000000, 999999998},
            {500000000, 999999998},
            {500000000, 500000002},
            {500000000, 999999998},
            {500000000, 999999998},
            {500000000, 499999998},
            {1000000000,4},
            {1000000000, 999999996},
            {500000000, 999999996},
            {500000000, 500000004},
            {500000000, 999999996},
            {500000000, 499999996},
            {1000000000, 6},
            {500000000, 999999994},
            {500000000 ,500000006},
            {500000000, 999999994},
            {500000000, 499999994},
            {1000000000, 8},
            {1000000000, 999999992}
        };
        for(int i=0; i<values.length; i++) {
            System.out.println("ANS : " + i + ":" + localTestFunction(values[i][0], values[i][1]));
        }
    }

    // private static long localTestFunction(long x, long y) {
    //     long i = 1;
    //     long j = 1; // 
    //     long numerator = ((x * i) + y);
    //     long denominator = (j + 1);
    //     long n = (numerator / denominator);
    //     while(true) {
    //         for(;; i = i * (y/x)) {
    //             for(j=i;j>0 && ((j-1) % y == 0) ;j--) {
    //                 numerator = ((x * i) + y);
    //                 denominator = (j + 1);
    //                 n = (numerator / denominator);
    //                 System.out.println("i : " + i + " j : " + j + " n : " + n);
    //                 if((numerator % denominator == 0) && ((n % x) == (y % n))) {
    //                     System.out.println("ANS to this "+"i : " + i + " j : " + j + " n : " + n);
    //                     return n;
    //                 }
    //             }
    //         }
    //     }
    // }

    private static double localTestFunction(long x, long y) {
        if(x > y) return (x+y);
        else if(3*x > y) return (x + y)/2;
        else {
            long l1 = (long) ((y - 2 * x) % x == 0 ? ((y - 2.0*x) / (x + 1)) : Math.ceil((y - 2.0*x) / x));

            return (l1 * x  + y) / 2;
        }
    }
}
