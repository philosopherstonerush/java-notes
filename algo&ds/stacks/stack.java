public class stack {
    private Node top;
    private int height;

    class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
        }
    }

    stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;

        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);

        // case when no node is present
        if(height == 0) {
            top = newNode;
        }

        // case when one or more nodes are present
        else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {

        // case when no nodes are there
        if(height == 0) {
            return null;
        } else {
            Node temp = top;
            top = top.next; // goes to null if only one node is there.
            temp.next = null;
            height--;
            return temp;
        }
    }
}
