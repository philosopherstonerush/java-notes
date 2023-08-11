public class linkedList {
    Node head = null;
    Node tail = null;
    int length = 0;

    //  Inner class to hold the value

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }

    linkedList (int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        head = newNode;
        tail = newNode;
        length++;
    }

    void printList() {
        Node temp = head;

        while(temp.next != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println(temp.value);
    }

    void append(int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        
        if(length == 0) {
            
            head = newNode;
            tail = newNode;
            length++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        length++;
    }

    Node removeLast() {
        
        if (length == 0) {
            return null;
        }

        if(length == 1) {
            Node temp = tail;
            head = null;
            tail = null;
            length--;
            return temp;
        }

        Node prev = head;

        while(prev.next.next != null) {
            prev = prev.next;
        }

        Node temp = tail;
        tail = prev;
        tail.next = null;
        length--;
        return temp;

    }

    void prepend(int value) {
        
        if(length == 0) {
            Node temp = new Node(value);
            head = temp;
            tail = temp;
            length++;
            return;
        }
        
        Node temp = new Node(value);
        temp.next = head;
        head = temp;
        length++;
    }

    Node removeFirst() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
           Node temp = head;
           head = null;
           tail = null;
           length--;
           return temp;
        }

        Node temp = head;
        head = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    Node get(int index) {
        if(index < 0 || index >= length) {
            return null;
        }

        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    boolean set(int index, int value) {
        Node temp = get(index);
        if(temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    boolean insert(int index, int value) {
        Node newNode = new Node(value);
        if(index < 0 || index > length) {
            return false;
        }

        if(index == length) {
            append(value);
            return true;
        }

        if(index == 0) {
            prepend(value);
            return true;
        }

        Node prev = get(index - 1);
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
        return true;
    }

    Node remove(int index) {
        if(index < 0 || index >= length) {
            return null;
        }

        if(index == length - 1) {
            return removeLast();
        }

        if(index == 0) {
            return removeFirst();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    void reverse() {
        if(length == 0 || length == 1) {
            return;
        }

        Node before = null;
        Node temp = head;
        Node after = head.next;

        head = tail;
        tail = temp;

        for(int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }
}
