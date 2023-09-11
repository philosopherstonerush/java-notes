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

        ListNode head = removeNthFromEnd(n1, 3);

        System.out.println("Done");

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode nodes[] = new ListNode[n+1];
        nodes[0] = head;

        for(int i = 1; i < nodes.length; i++) {
            nodes[i]= nodes[i-1].next;
        }



        while(nodes[n].next != null) {
            for(int i = 0; i < nodes.length; i++) {
                nodes[i] = nodes[i].next;
            }
        }

        nodes[0].next = nodes[2];
        nodes[1].next = null;

        return head;
    }
}
