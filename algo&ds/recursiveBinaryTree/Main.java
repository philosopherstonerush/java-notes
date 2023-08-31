public class Main  {
    public static void main(String[] args) {
        recursiveBST m = new recursiveBST();
        m.rInsert(2);
        m.rInsert(1);
        m.rInsert(3);
        m.rInsert(4);
        m.rInsert(1);

        m.rDelete(1);
        m.rDelete(4);


        m.rContains(1);
    }
}
