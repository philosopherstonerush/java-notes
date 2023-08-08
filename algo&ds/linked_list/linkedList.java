public class linkedList {
    Node head;
    Node tail;
    int lenght = 0;

    linkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.lenght = lenght + 1;
    }
    
}
