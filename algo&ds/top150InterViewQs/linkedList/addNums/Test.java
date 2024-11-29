public class Test {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, null);
        ListNode n2 = new ListNode(3, null);
        ListNode n3 = new ListNode(4, null);
        ListNode n4 = new ListNode(5, null);

        n1.next = n2;
        n3.next = n4;

        ListNode temp = addTwoNumbers(n1, n3);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }

}
