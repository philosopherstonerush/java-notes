public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(7);

        n1.next = n2;

        n4.next = n5;
        n5.next = n6;

        ListNode h = mergeTwoLists(n1, null);

        while(h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    }

}
