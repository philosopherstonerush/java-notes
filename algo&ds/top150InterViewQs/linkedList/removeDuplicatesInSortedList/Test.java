import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy;
        ListNode temp = before.next;

        while(temp != null && temp.next != null) {
            if(temp.val == temp.next.val) {
                before.next = findUniqueNode(temp, temp.val);
                temp = before.next;
            }
            else {
                before = before.next;
                temp = before.next;
            }
        }

        return dummy.next;

    }

    public static ListNode findUniqueNode(ListNode head, int avoid) {
        while(head != null && head.val == avoid) {
            head = head.next;
        }

        return head;

    }
    
}
