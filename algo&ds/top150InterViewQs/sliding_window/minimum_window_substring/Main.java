import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String s, String t) {

        if(s.length() == 0 || t.length() == 0 || s.length() < t.length() || s == null || t == null) {
            return "";
        }

        int[] tmap = new int[256];

        for(int i = 0; i < t.length(); i++) {
            tmap[t.charAt(i)]++;
        }

        int N = s.length();
        int right = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        int count = t.length();

        while(right < N) {
            // this will turn all the characters that are not in the t string to -1 or more if they appear more times.
            if(tmap[s.charAt(right++)]-- > 0) {
                count--;
            }
            // Once we have exhausted all the necessary characters
            while(count == 0) {
                // calculate and check if its the minlen
                if(right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                // reduce window until atleast one character is popped
                if(tmap[s.charAt(left++)]++ == 0) {
                    count++;
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "": s.substring(startIndex, startIndex + minLen);

    }
}
