import java.util.List;

/**
 *
 * To merge two sorted LinkedLists
 *
 */


class Main {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode temp = null;
        System.out.println("Merging");

        // Run till both of them are null, temp points to the linkedList with merged nodes. head is the first node of the merged list.

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                if(head == null) {
                    head = new ListNode(list1.val, null);
                    temp = head;
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list1.val, null);
                    temp = temp.next;
                    list1 = list1.next;
                }
            }
            else if(list1.val > list2.val) {
                if(head == null) {
                    head = new ListNode(list2.val, null);
                    temp = head;
                    list2 = list2.next;
                } else {
                    temp.next = new ListNode(list2.val, null);
                    temp = temp.next;
                    list2 = list2.next;
                }
            }
            else {
                if(head == null) {
                    head = new ListNode(list1.val, null);
                    temp = head;
                    list1 = list1.next;
                } else {
                    temp.next = new ListNode(list1.val, null);
                    temp = temp.next;
                    list1 = list1.next;
                }
            }
        }

        // if list1 still has nodes in it.
        if(list1 != null) {

            // case when you start with one list and the other one is null, the while loop before this didn't run so head isn't initialized.
            if(head == null) {
                head = new ListNode(list1.val, null);
                temp = head;
                list1 = list1.next;
            }

            while(list1 != null) {
                temp.next = new ListNode(list1.val, null);
                temp = temp.next;
                list1 = list1.next;
            }

        }

        // if list2 still has nodes in it.
        if(list2 != null) {
            if(head == null) {
                head = new ListNode(list2.val, null);
                temp = head;
                list2 = list2.next;
            }

            while(list2 != null) {
                temp.next = new ListNode(list2.val, null);
                temp = temp.next;
                list2 = list2.next;
            }

        }
        return head;
    }

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

        Main m = new Main();
        ListNode h = m.mergeTwoLists(n1, null);

        while(h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}