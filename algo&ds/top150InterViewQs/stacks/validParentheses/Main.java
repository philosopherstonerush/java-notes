import java.util.*;


/**
 *
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 */



public class Main {

    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }


    // https://leetcode.com/problems/valid-parentheses/solutions/3399077/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation/?envType=study-plan-v2&envId=top-interview-150

    public static boolean isValid(String s) {

        // Convert the given String into character array
        char[] charArr = s.toCharArray();

        // Initialize a new stack
        Stack<Character> str = new Stack<>();

        // Create a Hashmap with correct opening and closing brackets
        HashMap<Character, Character> dictForBrackets = new HashMap<>();
        dictForBrackets.put('{', '}');
        dictForBrackets.put('(', ')');
        dictForBrackets.put('[', ']');

        // iterate over the characters
        for (char c : charArr) {

            // see if its the opening bracket
            if(dictForBrackets.containsKey(c)) {
                str.push(c);
            } else {
                // check if the stack is empty - meaning closing bracket came before opening bracket - invalid
                if(str.isEmpty()) return false;
                char temp = str.pop();

                // check if the closing bracket is of the appropriate type
                if(c != dictForBrackets.get(temp)) {
                    return false;
                }
            }
        }

        // check if the stack has elements still in it - meaning not enough closing brackets
        if(!str.isEmpty()) return false;

        return true;
    }
}
