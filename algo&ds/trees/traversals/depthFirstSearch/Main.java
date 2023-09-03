public class Main {
    public static void main(String[] args) {
        binaryST myBST = new binaryST();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);

        System.out.println("\nDFS PreOrder:");
        System.out.println( myBST.depthFirstSearchPreOrder() );
    }
}
