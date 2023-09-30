/**
 *
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 * example:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * example:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 */

public class Main {

    public static void main(String[] args) {
        String seq = "axc";
        String test = "ahbgdc";

        System.out.println(isSubsequence(seq, test));

    }

    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.isBlank()) {
            return true;
        }
        if(t == null || t.isBlank()) {
            return false;
        }

        // since sequence string is always less than or equal to test string, we will iterate the test string characters and make sequence string our condition.

        int j = 0;
        for(int i = 0; i < t.length(); i++) {
            char compareChar = s.charAt(j);
            if(t.charAt(i) == compareChar) {
                j++;
                if(j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }


}
