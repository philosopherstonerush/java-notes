import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode head = removeNthFromEnd(n1, 1);

        System.out.println("Done");

    }

    /*
        Feels nice to solve it in my first try.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode before = null;
        ListNode currNode = head;

        // A gap is maintained so that when the forward node reaches the end, the currNode points to the Node that needs to be removed.
        ListNode forward = head;
        int gap = n - 1;

        for(int i = 0; i < gap; i++) {
            forward = forward.next;
        }

        while(forward.next != null) {
            forward = forward.next;
            before = currNode;
            currNode= currNode.next;
        }

        if(before !=null)
        {
            before.next = currNode.next;
        } else {
            // if before is null, then just remove the head
            head = currNode.next;
            currNode.next = null;
            return head;
        }

        currNode.next = null;
        return head;
    }
}
