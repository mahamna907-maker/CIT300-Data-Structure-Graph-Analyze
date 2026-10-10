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
/** Breadth-first traversal using a queue: O(V + E). */
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        lastSteps = 0;
        if (!adj.containsKey(start)) return order;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            order.add(v);
            lastSteps++;                          // vertex processed
            for (int n : adj.get(v)) {
                lastSteps++;                      // edge examined
                if (visited.add(n)) q.add(n);
            }
        }
        return order;
    }
/** Depth-first traversal using recursion: O(V + E). */
    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        lastSteps = 0;
        if (!adj.containsKey(start)) return order;
        dfsHelper(start, new HashSet<>(), order);
        return order;
    }
 
    private void dfsHelper(int v, Set<Integer> visited, List<Integer> order) {
        visited.add(v);
        order.add(v);
        lastSteps++;                              // vertex processed
        for (int n : adj.get(v)) {
            lastSteps++;                          // edge examined
            if (!visited.contains(n)) dfsHelper(n, visited, order);
        }
    }
    /** Fills the graph with a connected random graph (used by the benchmark and sample loader). */
    public void generateRandom(int vertices, int extraEdges, long seed) {
        adj.clear();
        Random r = new Random(seed);
        for (int i = 1; i <= vertices; i++) addVertex(i);
        for (int i = 2; i <= vertices; i++) addEdge(i, 1 + r.nextInt(i - 1));   // spanning tree keeps it connected
        for (int i = 0; i < extraEdges; i++) {
            int a = 1 + r.nextInt(vertices), b = 1 + r.nextInt(vertices);
            if (a != b && !adj.get(a).contains(b)) addEdge(a, b);
        }
    }
 
    public void loadSample() {
        adj.clear();
        for (int i = 1; i <= 7; i++) addVertex(i);
        int[][] e = {{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{5,6}};
        for (int[] x : e) addEdge(x[0], x[1]);
    }
    public void menu() {
        int c;
        do {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal\n5. DFS Traversal");
            System.out.println("6. Load sample graph\n7. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ", 1, 7);
            switch (c) {
                case 1 -> {
                    int v = InputHelper.readInt("Vertex number: ");
                    if (addVertex(v)) { System.out.println("Vertex " + v + " added."); PerformanceAnalyzer.log("Graph add vertex " + v); }
                }
                case 2 -> {
                    if (adj.size() < 2) { System.out.println("Add at least two vertices first."); break; }
                    int a = InputHelper.readInt("From vertex: ");
                    int b = InputHelper.readInt("To vertex: ");
                    if (addEdge(a, b)) { System.out.println("Edge " + a + " - " + b + " added."); PerformanceAnalyzer.log("Graph add edge " + a + "-" + b); }
                }
                case 3 -> display();
                case 4, 5 -> {
                    if (adj.isEmpty()) { System.out.println("Graph is empty. Add vertices or load the sample graph."); break; }
                    int s = InputHelper.readInt("Start vertex: ");
                    if (!hasVertex(s)) { System.out.println("Vertex " + s + " does not exist."); break; }
                    String name = c == 4 ? "BFS" : "DFS";
                    long t = System.nanoTime();
                    List<Integer> order = c == 4 ? bfs(s) : dfs(s);
                    t = System.nanoTime() - t;
                    System.out.println(name + " order: " + order + " | steps = " + lastSteps + " | time = " + t + " ns");
                    PerformanceAnalyzer.log(name + " from " + s + ": " + order + ", steps=" + lastSteps + ", time=" + t + " ns");
                }
                case 6 -> { loadSample(); System.out.println("Sample graph loaded (7 vertices, 7 edges)."); display(); }
                default -> { }
            }
        } while (c != 7);
    }

}
