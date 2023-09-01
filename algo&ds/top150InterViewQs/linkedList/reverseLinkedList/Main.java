import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        ListNode head = n1;

        head = m.reverseBetween(head, 1, 2);

        System.out.println("Done");


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null || head.next == null) {
            return null;
        }

        ListNode tempL = head;
        ListNode tempR = null;

        for(int i = 0; i < left; i++) {
            tempL = tempL.next;
        }

        tempR = tempL;

        for(int i = left; i < right; i++) {
            tempR = tempR.next;
        }

        ListNode before = tempL;
        ListNode temp = before.next;
        ListNode after = temp.next;

        while(temp != tempR.next) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        return head;

    }
}
