/**
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 */

public class Main {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sbTemp = new StringBuilder();

        /**
         *
         * reverse() converts the string from "world" to "dlrow"
         *
         */

        int index = s.length() - 1;

        // remove the trailing zeros first
        while(index >= 0) {
            if (s.charAt(index) != ' ') {
                break;
            }
            index--;
        }

        // if the space is before a character then clear the string so far formed in the sbTemp and append it to sb.
        while(index >= 0) {
            if(s.charAt(index) == ' ') {
                if(s.charAt(index + 1) != ' ') {
                    String t = sbTemp.reverse().toString();
                    sb.append(t).append(' ');
                    sbTemp = new StringBuilder();
                }
            } else {
                sbTemp.append(s.charAt(index));
            }
            index--;
        }

        // flush out the final string in sbTemp
        String t = sbTemp.reverse().toString();
        sb.append(t).append(' ');

        String ss = sb.toString().trim();
        return ss;

    }

}
