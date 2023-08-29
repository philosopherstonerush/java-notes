public class Main {
    public static void main(String[] args) {
        Main m = new Main();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return head;
        if(head.next == null) return head;
        if(left == right) return head;

        ListNode tempL = head;
        int diff = right - left;

        for(int i = 0; i < left - 2; i++) {
            tempL = tempL.next;
        }

        ListNode before = tempL.next;
        ListNode temp = before.next;
        ListNode after = temp.next;

        for(int i = 0; i < diff; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        ListNode end = tempL.next;
        ListNode front = temp;
        tempL.next = null;
        tempL.next = front;
        after.next = end;

        return head;

    }
}
