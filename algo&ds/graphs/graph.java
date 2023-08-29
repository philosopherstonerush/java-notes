import java.util.ArrayList;
import java.util.HashMap;

public class graph {

    /*//
           Implemented it via Adjacency List as Matrix is quite cumbersome to deal with.
     */

    HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if(adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }


    /*//
            Implemented it for bidirectional graphs - its highly efficient since, it is guaranteed that only the vertexes that are joined is mentioned in the arraylist of the vertex that has to be removed. So you don't have to iterate through all vertexes and edges to find the particular vertex to be removed.
     */
    public boolean removeVertex(String vertex) {

        if(adjList.get(vertex) == null) return false;

        for(String v: adjList.get(vertex)) {
            adjList.get(v).remove(vertex);
        }

        adjList.remove(vertex);

        return true;
    }

    public void printGraph() {
        adjList.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
