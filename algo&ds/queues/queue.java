public class queue {
    private Node first;
    private Node last;
    private int height;

    class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    queue(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        height++;
    }

    public void printQueue() {
        Node temp = first;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enQueue(int value) {
        Node newNode = new Node(value);

        // case when no node in the data structure

        if(height == 0) {
            first = newNode;
            last = newNode;
            newNode.next = null;
        }
        else {
            last.next = newNode;
            last = newNode;
            newNode.next = null;
        }
        height++;
    }

    public Node deQueue() {

        // case when no node is present
        if(height == 0) return null;

        Node temp = first;

        // case when one node is present
        if(height == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            temp.next = null;
        }
        height--;
        return temp;
    }

}
