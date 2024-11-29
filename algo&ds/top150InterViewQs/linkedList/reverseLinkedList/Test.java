public class Test {

    public static void main(String args[]) {
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

        head = reverseBetween(head, 2, 7);

        System.out.println("Done");
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

    }

}
