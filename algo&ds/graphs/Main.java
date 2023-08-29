public class Main {
    public static void main(String[] args) {
        graph g = new graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.printGraph();
        g.removeVertex("A");
        g.printGraph();
    }
}
