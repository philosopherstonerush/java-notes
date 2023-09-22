
/*

    Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    ex: [1, 4, 3, 2, 5, 2] ---> [1, 2, 2, 4, 3, 5]

 */

public class Main {

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(1);
        n7.next = n8;
        n8.next = null;

        ListNode head = partition(n1, 2);
        System.out.println("done");
    }

    public static ListNode partition(ListNode head, int x) {

        /*

            Simply break the list into two separate chains - for numbers that are lesser and another for numbers that are greater than or equal to. Join them and return.

         */

        if(head == null) return head;

        ListNode dummyGreater = new ListNode(0, null);
        ListNode tempGreater = dummyGreater;
        ListNode dummyLesser = new ListNode(0, null);
        ListNode tempLesser = dummyLesser;
        ListNode temp = head;

        while(temp != null) {
            if(temp.val < x) {
                tempLesser.next = new ListNode(temp.val, null);
                tempLesser = tempLesser.next;
            } else {
                tempGreater.next = new ListNode(temp.val, null);
                tempGreater = tempGreater.next;
            }

            temp = temp.next;
        }

        tempLesser.next = dummyGreater.next;

        return dummyLesser.next;

    }
}
