import java.util.Stack;

/**
 *
 *
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * constraints:
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 *
 *
 */


/**
 *
 *
 * This calc only involves + or -, no multiplication or division.
 *
 *
 */

public class basicCalc {

    public static void main(String[] args) {
        String test = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(test));
    }

    public static int calculate(String s) {
        // result is what holds our result so far
        int result = 0;
        // the number we currently have to evaluate
        int number = 0;
        // the positive sign is taken as default
        int sign = 1;
        // Used if '(' or ')' are used.
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                // each digit in a number is stored, (int) converts the char to an integer.
                number = 10 * number + (int)(c - '0');
            } else if (c == '+') {
                // evaluate the previous expression.
                result += sign * number;
                // reset number to 0
                number = 0;
                // replace the sign now to plus
                sign = 1;
            } else if (c == '-') {
                // evaluate the previous expression
                result += sign * number;
                // reset number to 0
                number = 0;
                // replace the sign to be minus.
                sign = -1;
            } else if (c == '(') {
                // put result first, so it comes out last
                stack.push(result);
                stack.push(sign);
                // reset result to be zero for the current bracket expression
                result = 0;
                // default sign is +
                sign = 1;

                // why number not reset to 0? checkout readme
            } else if (c == ')') {
                // finish evaluating the last expression.
                result += sign * number;
                // reset number
                number = 0;
                // take sign out, and then add the previous result.
                result *= stack.pop();
                result += stack.pop();
            }
        }
        // if number is not zero - meaning a number is present then add it to the result.
        if (number != 0) result += sign * number;
        return result;
    }
}