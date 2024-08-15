/**
 *
 * Though I wouldnt call this a doubly linked list in the literal sense, but still I have this done using just array.
 *
 * STEPS:
 * 1) Clean the string of non-alphanumeric values. Consider using Character.isLetterOrDigit() over manual regex.
 * 2) Reverse the String.
 * 3) Iterate and compare the two strings.
 *
 */

public class Main {
    public static void main(String[] args) {
        String s = new String(" ");
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }

        }

        return sb.toString().contentEquals(sb.reverse());
    }
}

