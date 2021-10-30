package FB_Excercise.Arrays;

import java.util.*;

public class PairSums {
    
    public static void main(String[] arr) {
        int[] arr_1 = {1, 2, 3, 4, 3};
        int[] arr_2 = {1, 5, 3, 3, 3};
        System.out.println("Number of different pairs of elements which sum to 6 : " + numberOfWays(arr_1, 6));
        System.out.println("Number of different pairs of elements which sum to 6 : " + numberOfWays(arr_2, 6));
    }

    public static int numberOfWays(int[] arr, int k) {
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            if(!reverseMap.containsKey(arr[i])) {
                reverseMap.put(arr[i], new ArrayList<>());
            }
            reverseMap.get(arr[i]).add(i);
        }
        int count = 0;
        Set<String> visited = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(reverseMap.containsKey(k - arr[i])) {
                for(int index : reverseMap.get(k - arr[i])) {
                    if(i != index && !visited.contains(i + ":" + index) && !visited.contains(index + ":" + i)) {
                        count++;
                        visited.add(i + ":" + index);
                        visited.add(index + ":" + i);
                    }
                }
            }
        }
        return count;
    }
}
