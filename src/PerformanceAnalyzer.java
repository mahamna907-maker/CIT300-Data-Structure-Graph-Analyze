import java.util.*;

/** Benchmarks searching and graph traversal, and keeps a log of all results. */
public class PerformanceAnalyzer {
    private static final List<String> results = new ArrayList<>();

    public static void log(String entry) { results.add(entry); }

    public static void showAllResults() {
        System.out.println("\n=============================================");
        System.out.println(" ALL RECORDED RESULTS");
        System.out.println("=============================================");
        if (results.isEmpty()) System.out.println("No results recorded yet. Use the other menus first.");
        else for (int i = 0; i < results.size(); i++) System.out.println((i + 1) + ". " + results.get(i));
    }
        public static void runComparison() {
        int n = InputHelper.readInt("Dataset size for search test (10 - 1000000): ", 10, 1000000);

        // Sorted data 0,2,4,... ; target = last element (worst case for linear search)
        int[] data = new int[n];
        for (int i = 0; i < n; i++) data[i] = i * 2;
        int target = data[n - 1];

        long t = System.nanoTime();
        int[] lin = SearchOperations.linearSearch(data, target);
        long linTime = System.nanoTime() - t;
        t = System.nanoTime();
        int[] bin = SearchOperations.binarySearch(data, target);
        long binTime = System.nanoTime() - t;

        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.printf("%-16s %-16s %-10s %-12s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("-------------------------------------------------------");
        row("Search", "Linear Search", lin[1], linTime);
        row("Search", "Binary Search", bin[1], binTime);
        System.out.println("=============================================");
        System.out.println("Search: n = " + n + " (worst-case target). Linear is O(n), binary is O(log n).");
        log(String.format("Performance (n=%d): Linear steps=%d, Binary steps=%d", n, lin[1], bin[1]));
    }

    private static void row(String op, String alg, int steps, long time) {
        System.out.printf("%-16s %-16s %-10d %-12d%n", op, alg, steps, time);
    }
}