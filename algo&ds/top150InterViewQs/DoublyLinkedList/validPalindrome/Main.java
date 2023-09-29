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
        if(s.isBlank()) return true;
        int right = s.length() - 1;
        s = s.toLowerCase();

        String stringToCompare = cleanAllNonAlphaValues(s);
        String reversedStringToCompare = reverseTheString(stringToCompare);

        for(int i = 0; i < stringToCompare.length(); i++) {
            if(stringToCompare.charAt(i) != reversedStringToCompare.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isAlphaNumeric(char ch) {
        return (ch >= '0' & ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    static String cleanAllNonAlphaValues(String s) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(isAlphaNumeric(s.charAt(i))) {
                output.append(s.charAt(i));
            }
        }
        return output.toString();
    }

    static String reverseTheString(String s) {
        StringBuilder output = new StringBuilder();
        for(int i = s.length() - 1; i >=0 ; i--) {
            output.append(s.charAt(i));
        }
        return output.toString();
    }
}

