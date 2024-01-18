/**
 *
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 */

public class Main {
    public static void main(String[] args) {
        String hayStack = "mississippi";
        String needle = "issip";

        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {

        int haystack_len = haystack.length();
        int needle_len = needle.length();

        if(haystack_len < needle_len) {
            return -1;
        }

        for(int i = 0; i < haystack_len - needle_len; i++) {
            int j = 0;

            while(j < needle_len && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }

            if(j == needle_len) {
                return i;
            }
        }

        return -1;

    }

}
