/**
 *
 * Each node in the linked list has a Node random variable that points to a random node in the list or a null value.
 *
 */

public class Main {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.random = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        Node temp = n1;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        Main m = new Main();
        temp = m.copyLeetCode(n1);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    // My method - O(n^2)
    public Node copyRandomList(Node head) {

        Node temp = head;
        Node headNew = null;
        Node tempNew = null;

        // Creating the new linkedlist without the random pointers.
        while(temp != null) {

            if(headNew == null) {
                headNew = new Node(temp.val);
                tempNew = headNew;
                temp = temp.next;
            }

            else {
                tempNew.next = new Node(temp.val);
                tempNew = tempNew.next;
                temp = temp.next;
            }
        }

        // reset temp and tempNew, create temp1 which goes through the nodes in both cloned and original list while randomP is used to point to the node pointed by random member variable.

        temp = head;
        Node temp1 = null;
        tempNew = headNew;
        Node randomP = null;

        // find the index of the node pointed by randomP
        int index = 0;

        while(temp != null) {

            // get node pointed by randomP
            randomP = temp.random;

            // if its null then tempNew.random is also null
            if (randomP == null) {
                tempNew.random = null;
            }
            else {

                // iterate the original list to find index of the randomP node
                temp1 = head;
                while(temp1 != randomP) {
                    temp1 = temp1.next;
                    index++;
                }

                // iterate the cloned list to the index found out previously and assign it to tempNew.random
                temp1 = headNew;
                int count = 0;
                while(count != index) {
                    temp1 = temp1.next;
                    count++;
                }
                tempNew.random = temp1;
            }
            tempNew = tempNew.next;
            temp = temp.next;
            index = 0;
        }
        return headNew;
    }

    // Best way - O(n) time complexity
    public Node copyLeetCode(Node head) {

        // temp is not used to traverse instead as a holder for new nodes.
        Node original = head;
        Node temp;

        if (head == null) {
            return head;
        }

        /* //
        1. Make new cloned nodes, do not care about random pointers, cloned nodes come after original nodes.

        ex: original1 --> cloned1 --> original2 --> cloned2 etc
         */

        while(original != null) {
            temp = new Node(original.val);
            temp.next = original.next;
            original.next = temp;
            original = temp.next;
        }

        /*
        2. Copy the random pointers.

        original.next = cloned node
        original.next.random = cloned node random

        original.random = original node random
        original.random.next = original node random next -> cloned node like it.
         */
        original = head;
        while(original != null) {
            if(original.random != null) {
                original.next.random = original.random.next;
            }
            // skip the cloned node
            original = original.next.next;
        }


        /*
        3. Separate cloned and original nodes.
         */
        original = head;
        Node clonedHead = head.next;
        Node copy = clonedHead;

        while(original != null) {
            original.next = copy.next;
            original = original.next;
            if(original != null) {
                copy.next = original.next;
                copy = copy.next;
            }
        }

        return clonedHead;
    }
}
