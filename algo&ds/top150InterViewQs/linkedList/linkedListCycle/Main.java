import java.util.HashMap;
import java.util.Optional;


/**
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 *
 */


public class Main {
    public boolean hasCycle(ListNode head) {

        // this is how I solved it for the first time but it has very slow runtime performance

        HashMap<ListNode, Boolean> h = new HashMap<>();
        ListNode temp = head;
        while(temp != null) {

            if(Optional.ofNullable(h.get(temp)).orElse(false)) {
                return true;
            }
            h.put(temp, true);
            temp = temp.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {

        /**
         * This is the accepted leetcode answer with O(1) memory performance - not time.
         * Imagine there are two runners in a track, one who runs faster compared to another and are running in the same direction - at one point they are bound to cross each other at the same point.
         */

        ListNode fast = head;
        ListNode slow = head;

        if(head == null) {
            return false;
        }
        if(head.next == null) {
            return false;
        }

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main m = new Main();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;
        n2.next = n1;

        System.out.println(m.hasCycle2(n1));
    }
}
