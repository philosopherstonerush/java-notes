import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Test {


    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(1);
        test.push(-2);
        test.push(0);
        test.push(-3);
        test.pop();
        System.out.println(test.getMin());
    }




}
