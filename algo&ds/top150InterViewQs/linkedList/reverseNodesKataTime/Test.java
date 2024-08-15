import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        ListNode head = reverseKGroup(n1, 3);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

    }


}
