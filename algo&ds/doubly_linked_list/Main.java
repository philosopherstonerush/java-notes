public class Main {
    public static void main(String[] args) {
        DDLinkedList li = new DDLinkedList(8);
        li.append(9);
        li.append(10);

        System.out.println(li.remove(1).value);
        li.printList();
    }
}
