public class Main {

    public static void main(String[] args) {
        queue Q = new queue(7);
        Q.printQueue();
        Q.enQueue(8);
        Q.printQueue();
        Q.deQueue();
        Q.printQueue();
    }
}
