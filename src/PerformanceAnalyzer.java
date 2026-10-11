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
}