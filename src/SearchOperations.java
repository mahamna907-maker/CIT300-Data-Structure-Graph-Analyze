import java.util.Arrays;
import java.util.Random;
 
/** Linear and binary search with step counting and a side-by-side comparison. */
public class SearchOperations {
    private int[] dataset = new int[0];      // kept sorted so both searches can be used
 
    /** @return {index, steps}; index = -1 if not found. */
    public static int[] linearSearch(int[] arr, int target) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) return new int[]{i, steps};
        }
        return new int[]{-1, steps};
    }
 
    /** @return {index, steps}; arr MUST be sorted ascending. */
    public static int[] binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1, steps = 0;
        while (lo <= hi) {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return new int[]{mid, steps};
            if (arr[mid] < target) lo = mid + 1; else hi = mid - 1;
        }
        return new int[]{-1, steps};
    }
        private void enterManually() {
        String line = InputHelper.readLine("Enter whole numbers separated by spaces or commas: ");
        String[] parts = line.split("[,\\s]+");
        int[] tmp = new int[parts.length];
        try {
            for (int i = 0; i < parts.length; i++) tmp[i] = Integer.parseInt(parts[i]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: only whole numbers are allowed. Dataset unchanged.");
            return;
        }
        Arrays.sort(tmp);   // binary search requires sorted data
        dataset = tmp;
        System.out.println("Dataset stored and sorted (needed for binary search): " + Arrays.toString(dataset));
    }
 
    private boolean hasData() {
        if (dataset.length == 0) { System.out.println("Dataset is empty. Use option 1 or 2 first."); return false; }
        return true;
    }
    private long[] timedLinear(int t) { long s = System.nanoTime(); int[] r = linearSearch(dataset, t); return new long[]{r[0], r[1], System.nanoTime() - s}; }
    private long[] timedBinary(int t) { long s = System.nanoTime(); int[] r = binarySearch(dataset, t); return new long[]{r[0], r[1], System.nanoTime() - s}; }
 
    private void report(String name, int target, long[] r) {
        String res = r[0] == -1 ? "NOT FOUND" : "found at index " + r[0];
        System.out.printf("%-14s: %s | steps = %d | time = %d ns%n", name, res, r[1], r[2]);
        PerformanceAnalyzer.log(name + " (target " + target + "): " + res + ", steps=" + r[1] + ", time=" + r[2] + " ns");
    }
public void menu() {
        int c;
        do {
            System.out.println("\n------------- SEARCHING OPERATIONS -------------");
            System.out.println("1. Enter dataset manually\n2. Generate random dataset\n3. Display dataset");
            System.out.println("4. Linear Search\n5. Binary Search\n6. Compare both searches\n7. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ", 1, 7);
            switch (c) {
                case 1 -> enterManually();
                case 2 -> {
                    int n = InputHelper.readInt("How many elements (1-100000)? ", 1, 100000);
                    Random r = new Random();
                    dataset = r.ints(n, 0, n * 3).toArray();
                    Arrays.sort(dataset);
                    System.out.println("Generated " + n + " sorted random numbers.");
                }
                case 3 -> {
                    if (!hasData()) break;
                    System.out.println(dataset.length > 50
                            ? "Dataset has " + dataset.length + " elements. First 50: " + Arrays.toString(Arrays.copyOf(dataset, 50)) + " ..."
                            : "Dataset (sorted): " + Arrays.toString(dataset));
                }
                case 4, 5, 6 -> {
                    if (!hasData()) break;
                    int target = InputHelper.readInt("Value to search: ");
                    if (c != 5) report("Linear Search", target, timedLinear(target));
                    if (c != 4) report("Binary Search", target, timedBinary(target));
                }
                default -> { }
            }
        } while (c != 7);
    }

}
