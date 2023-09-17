import java.util.List;

/*
 * reverse linked list only between two indexes.
 */

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;

        ListNode head = n1;

        head = m.reverseBetween(head, 2, 7);

        System.out.println("Done");


    }

    // Use pen and paper and traverse the algo with diagrams, you will understand.

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) return null;
        if(head.next == null) return null;


        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;

        for(int i = 0; i < left - 1; i++) {
            temp = temp.next;
        }
        ListNode currNode = temp.next;
        System.out.println("currNode value " + currNode.val);
        System.out.println("temp value " + temp.val);
        printList(head);

        for(int i = 0; i < right - left; i++) {
            ListNode forw = currNode.next;
            currNode.next = forw.next;
            forw.next = temp.next;
            temp.next = forw;
            System.out.println("forw value " + forw.val);
            System.out.println("currNode value " + currNode.val);
            System.out.println("temp value " + temp.val);
            System.out.println(i + " iteration");
            printList(dummy.next);
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while(temp.next != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
}
