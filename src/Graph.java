import java.util.*;
 
/** Undirected graph stored as an adjacency list, with BFS and DFS (step counted). */
public class Graph {
    private final Map<Integer, List<Integer>> adj = new TreeMap<>();
    private int lastSteps = 0;
 
    public boolean isEmpty() { return adj.isEmpty(); }
    public boolean hasVertex(int v) { return adj.containsKey(v); }
    public int getLastSteps() { return lastSteps; }
    public int vertexCount() { return adj.size(); }
 
    public boolean addVertex(int v) {
        if (adj.containsKey(v)) { System.out.println("Vertex " + v + " already exists."); return false; }
        adj.put(v, new ArrayList<>());
        return true;
    }
}
