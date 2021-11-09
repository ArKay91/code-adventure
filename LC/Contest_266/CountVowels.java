package LC.Contest_266;

public class CountVowels {
    

    public static void main(String[] args) {

    }

    public long countVowels(String word) {
        long ans = 0;
        long size = word.length();
        

        for(long i=0; i<size; i++) {
            char ch = word.charAt((int) i);
            //     i
            // a b a c (2+1)*(4-2) = 6 substrings can be formed.
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ans += (i+1)*(size-i);
            }
        }

        return ans;
    }
}
