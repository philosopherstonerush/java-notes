import com.sun.source.tree.LiteralTree;

import java.util.List;

public class Main {
    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = null;

        ListNode head = deleteDuplicates(n1);
        System.out.println(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {

        /*
            1) Check if there is atleast two nodes in the list.

            2) Create a dummy, that will help our before pointer.

            3) Create a node called currNode that will have a one node gap between before and itself.

            4) if before's next node's val is not equal to currNode, then just move them both.

            5) if they are equal then call the helper function to find the next node that isn't equal to the value, return null, if no such node is found.

            6) connect before with currNode or next non-duplicate node. Starting before with null will create problems in this line.

            7) If currNode is not null, then move currNode to create one node gap between before and currNode

            8) Remove dummy by return dummy.next
         */

        if(head == null) return null;
        if(head.next == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode before = dummy;
        ListNode currNode = head.next;

        while (currNode != null) {
            if(before.next.val == currNode.val) {
                currNode = findNode(currNode, currNode.val);
                before.next = currNode;
                if(currNode != null) {
                    currNode = currNode.next;
                }
            } else {
                before = before.next;
                currNode = currNode.next;
            }
        }

        return dummy.next;

    }

    public static ListNode findNode(ListNode currNode, int key) {

        while(currNode.val == key && currNode.next != null) {
            currNode= currNode.next;
        }

        if(currNode.val != key) {
            return currNode;
        } else {
            return null;
        }

    }
}
