public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;
        n2.next = n1;

        System.out.println(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {

    }
}
