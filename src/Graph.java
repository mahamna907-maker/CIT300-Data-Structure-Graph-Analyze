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
    public boolean addEdge(int a, int b) {
        if (!adj.containsKey(a) || !adj.containsKey(b)) { System.out.println("Both vertices must exist first."); return false; }
        if (a == b) { System.out.println("Self-loops are not allowed."); return false; }
        if (adj.get(a).contains(b)) { System.out.println("Edge already exists."); return false; }
        adj.get(a).add(b);
        adj.get(b).add(a);              // undirected
        return true;
    }
 	
    public void display() {
        if (adj.isEmpty()) { System.out.println("Graph is empty."); return; }
        System.out.println("Adjacency List:");
        adj.forEach((v, n) -> System.out.println("  " + v + " -> " + n));
    }

}
