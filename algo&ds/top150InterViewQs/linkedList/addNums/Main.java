public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, null);
        ListNode n2 = new ListNode(3, null);
        ListNode n3 = new ListNode(4, null);
        ListNode n4 = new ListNode(5, null);

        n1.next = n2;
        n3.next = n4;

        Main m = new Main();

        ListNode temp = m.addTwoNums(n1, n3);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    // my method
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         *
         * I modelled it as what I did from merge two linked lists.
         *
         */

        int r = 0; // remainder
        int q = 0; // quotient
        ListNode head = null;
        ListNode temp = null;

        // if nothing is passed then nothing is to do.
        if(l1 == null && l2 == null) {
            return head;
        }

        // sum is zero to start with
        int sum = 0;

        // if both nodes are present
        while(l1 != null && l2 != null) {

            // add two nodes' values and then add quotient
            sum = l1.val + l2.val + q;

            // find the remainder to make node
            r = sum % 10;

            // find the carry, we don't need a floorDiv since int already truncates the decimals
            q = Math.floorDiv(sum, 10);

            // For the first node.
            if(temp == null) {
                temp = new ListNode(r, null);
                head = temp;
                l1 = l1.next;
                l2 = l2.next;
            }

            // Nodes after
            else {
                temp.next = new ListNode(r, null);
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }

        // if l1 nodes are still present
        if(l1 != null) {
            while(l1 != null) {
                sum = l1.val + q;
                r = sum % 10;
                q = Math.floorDiv(sum, 10);

                // First node
                if(temp == null) {
                    temp = new ListNode(r, null);
                    head = temp;
                    l1 = l1.next;
                }

                // Nodes after
                else {
                    temp.next = new ListNode(r, null);
                    temp = temp.next;
                    l1 = l1.next;
                }
            }
        }

        if(l2 != null) {
            while(l2 != null) {
                sum = l2.val + q;
                r = sum % 10;

                // we don't need a
                q = Math.floorDiv(sum, 10);
                if(temp == null) {
                    temp = new ListNode(r, null);
                    head = temp;
                    l2 = l2.next;
                }
                else {
                    temp.next = new ListNode(r, null);
                    temp = temp.next;
                    l2 = l2.next;
                }
            }
        }

        // if carry is still present
        if(q != 0) {
            temp.next = new ListNode(q, null);
            return head;
        }
        else {
            return head;
        }
    }

    // leetcode best submission
    public ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;

        // clever way to put it all into one single while loop
        while(l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit2 + digit1 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit, null);
            temp = temp.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

        }

        // delete the dummy head created at first.
        ListNode temp2 = head;
        head = head.next;
        temp2.next = null;
        return head;
    }
}
