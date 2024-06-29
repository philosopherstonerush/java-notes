
/*
 * reverse nodes k units at a time, for example if k = 3 then first 3 nodes then 3 nodes etc.
 */

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

//        ListNode head = reverseKGroup(n1, 2);
//
//        while(head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        int left = 1;
        int right = left + k - 1;

        ListNode result = head;
        while(right <= count) {
            result = reverseWithPos(result, left, right);
            left = left + k;
            right = left+k-1;
        }
        return result;
    }

    public ListNode reverseWithPos(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;

        for(int i = 0; i < left - 1; i++) {
            temp = temp.next;
        }

        ListNode currNode = temp.next;

        for(int i = 0; i < right - left; i++) {
            ListNode forw = currNode.next;
            currNode.next = forw.next;
            forw.next = temp.next;
            temp.next = forw;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}
