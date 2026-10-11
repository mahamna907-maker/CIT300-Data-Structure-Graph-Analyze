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
}
