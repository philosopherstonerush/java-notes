
// Kinda refer this for singly linked list as well, I have better readable code here.

public class DDLinkedList {
    Node head;
    Node tail;
    int length;

    DDLinkedList(int value) {
        Node temp = new Node(value);
        head = temp;
        tail = temp;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node temp = new Node(value);

        // No node in the list

        if(length == 0) {
            head = temp;
        }

        // Atleast one node in the list

        else {
            tail.next = temp;
            temp.prev = tail;
        }
        tail = temp;
        length++;
    }

    public Node removeLast() {
        Node temp;

        // No node in the list

        if(length == 0) {
            return null;
        }

        // One node in the list

        if(length == 1) {
            temp = head;
            head = null;
            tail = null;
            length--;
            return temp;
        }

        temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node temp = new Node(value);

        // No node in the list

        if(length == 0) {
            head = temp;
            tail = temp;
            length++;
            return;
        }

        head.prev = temp;
        temp.next = head;
        temp.prev = null;

        head = temp;
        length++;
    }

    public Node removeFirst() {
        Node temp;

        // No node in the list

        if(length == 0) {
            return null;
        }

        // One node in the list

        if (length == 1) {
            temp = head;
            head = null;
            tail = null;
        }
        else {
            temp = head;
            head = temp.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {

        if(index < 0 || index >= length) {
            return null;
        }

        // Efficient get method, since if the node we want is close head, we can iterate from head or else if its close to tail then iterate from tail.

        Node temp = head;
        if(index < length/2) {
            for(int i = 0; i  < index; i++) {
                temp = temp.next;
            }
        }
        else {
            temp = tail;
            for(int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;

    }

    public boolean set(int index, int value) {

        // get the node that needs to be edited and it can return two possible values - null and node
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {

        // not >= length because we can insert something at the end

        if(index < 0 || index > length) {
            return false;
        }

        if(index == 0) {
            prepend(value);
            return true;
        }

        if(index == length) {
            append(value);
            return true;
        }

        Node temp = new Node(value);
        Node before = get(index - 1);
        Node after = before.next; // DO NOT USE GET() FOR THIS ---> O(N) but doing this way its O(1)
        temp.next = after;
        temp.prev = before;
        before.next = temp;
        after.prev = temp;
        length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }

        if(index == 0) {
           return removeFirst();
        }

        if(index == length - 1) {
            return removeLast();
        }

        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.prev = null;
        temp.next = null;
        length--;
        return temp;

    }
}
