public class Main {
    public static void main(String[] args) {
        RandomizedSet rr = new RandomizedSet();
        rr.insert(0);
        rr.insert(1);
        rr.remove(0);
        rr.insert(2);
        rr.remove(1);
        rr.getRandom();
    }
}
