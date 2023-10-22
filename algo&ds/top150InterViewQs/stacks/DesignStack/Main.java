import java.util.LinkedList;


/**
 *
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 *
 */

public class Main {

    LinkedList<Integer> ll;

    // Stack like implementation to keep track of minimum elements
    LinkedList<Integer> minll;

    public Main() {
        this.ll = new LinkedList<>();
        this.minll = new LinkedList<>();
    }

    public void push(int val) {

        // insert the new elements in the front

        if(minll.isEmpty()) {
            this.minll.push(val);
        } else {

            // check if its lesser than the current minimum element, then push it in the front.
            if (val <= minll.get(0)) {
                this.minll.push(val);
            }
        }

        this.ll.push(val);
    }

    public void pop() {

        // remove the head node, check if its the minimum element then go back to the previous minimum element

        int temp = this.ll.pop();
        if(this.minll.get(0) == temp) {
            this.minll.pop();
        }
    }

    public int top() {
        int temp = this.ll.get(0);
        return temp;
    }

    public int getMin() {
        // return the head value
        return this.minll.get(0);
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.push(1);
        test.push(-2);
        test.push(0);
        test.push(-3);
        test.pop();
        System.out.println(test.getMin());
    }
}
