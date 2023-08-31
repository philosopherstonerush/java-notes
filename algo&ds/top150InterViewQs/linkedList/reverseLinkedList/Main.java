public class Main {
    public static void main(String[] args) {
        Main m = new Main();
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        /*//
                case-1 : only one node in the linked list

                case-2: left == right

                case-3: no nodes between left and right

                case-4: one node, two nodes, three nodes and more than three
         */




        if(head == null) return head;
        if(head.next == null) return head;
        if(left == right) return head;

        ListNode tempL = head;
        int diff = right - left;

        for(int i = 0; i < left - 2; i++) {
            tempL = tempL.next;
        }

        ListNode tempR = tempL;

        for(int i = 0; i < right - 1; i++) {
            tempR = tempR.next;
        }

        ListNode before = tempL.next;
        ListNode temp = before.next;
        ListNode after = temp.next;

        if(diff == 1) {
            temp.next = before;
        }

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
