package FB_Excercise.Arrays;

public class ContiguousSubarrays {
    
    public static void main(String[] arr) {
        int[] nums = new int[] {3, 4, 1, 6, 2};
        System.out.println("Count of Contiguous Subarrays for [3, 4, 1, 6, 2] : " + countContiguousSubarrays(nums));
    }

    public static String countContiguousSubarrays(int[] arr) {
        int i=0, j=0, n = arr.length-1;
        int[] count = new int[n+1];
        while(i <= n) {
            int tempCount = 1;
            int max = arr[i];
            j = i;
            while(j-1 >=0 && arr[j-1] < max) {
                j--;
                tempCount++;
            }
            j = i;
            while(j+1 <= n && arr[j+1] < max) {
                j++;
                tempCount++;
            }
            count[i] = tempCount;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(int c : count) {
            sb.append(c + " ");
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
