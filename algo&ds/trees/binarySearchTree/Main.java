public class Main {
    public static void main(String[] args) {
        binaryST bst = new binaryST();

        bst.insert(2);
        bst.insert(5);

        System.out.println(bst.contains(6));

    }
}
