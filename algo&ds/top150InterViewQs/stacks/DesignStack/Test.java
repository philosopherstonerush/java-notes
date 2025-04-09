import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(512);
        test.push(-1024);
        test.push(-1024);
        test.push(512);
        test.pop();
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
        test.pop();
        System.out.println(test.getMin());
    }

}
