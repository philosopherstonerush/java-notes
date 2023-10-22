import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    //

    public static int evalRPN(String[] tokens) {

        Stack<Integer> integerStack = new Stack<>();

        for(String s: tokens) {

            try {

                int temp = Integer.parseInt(s);
                integerStack.push(temp);

            } catch (Exception e) {
                //careful here
                int num2 = integerStack.pop();
                int num1 = integerStack.pop();
                int res;

                if(s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else {
                    res = num1 / num2;
                }

                integerStack.push(res);

            }

        }

        int result = integerStack.pop();

        if(integerStack.isEmpty()) {
            return result;
        } else {
            return 0;
        }
    }
}
