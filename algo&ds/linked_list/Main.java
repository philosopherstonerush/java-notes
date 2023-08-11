

class Main {
    public static void main(String[] args) {
        linkedList li = new linkedList(6);
        li.insert(1, 7);
        li.insert(2, 9);
        li.set(2, 10);
        System.out.println(li.removeLast().value);
        System.out.println(li.removeLast().value);
    }
}