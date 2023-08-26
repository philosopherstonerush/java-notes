

/**
 *
 * To rotate linked list
 *
 * Always remember to handle cases when there are no nodes, 1 node and multiple nodes.
 *
 * imp - the number of rotations can be reduced by using mod.
 *
 */


public class Main {
    private int length = 0;


    public LinkedList rotateRight(LinkedList t, int k) {
        LinkedList temp = t;

        // find length
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        // handle cases when there is only 0 or 1 node. Rotations do not apply
        if(length == 0) {
            return null;
        }
        if(length == 1) {
            return t;
        }

        // reduce the number of rotations to k mod length
        k = k % length;

        for(int i = 0; i < k; i++) {
            t = removeAndAdd(t);
        }

        return t;
    }

    public LinkedList removeAndAdd(LinkedList t) {

        // remove last node and add to the front

        LinkedList last = null;
        LinkedList temp = t;

        while(temp.next.next != null) {
            temp = temp.next;
        }

        last = temp.next;
        temp.next = null;
        last.next = t;
        return last;
    }
}
