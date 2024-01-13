import java.util.Arrays;

/**
 *
 *
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
 *
 *
 */

public class Main {

    public static void main(String[] args) {
        String[] test = new String[]{"flower","flow","flight"};
        String output = longestCommonPrefix(test);
        System.out.println(output);

    }

    public static String longestCommonPrefix(String[] strs) {
        // Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if(first.charAt(i) != last.charAt(i)) {
                break;
            }
            sb.append(first.charAt(i));
        }

        return sb.toString();
    }
}
