/** Fixed-capacity array with insert, delete, search and display. */
public class ArrayOperations {
    public static final int CAPACITY = 20;
    private final int[] data = new int[CAPACITY];
    private int size = 0;
 
    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == CAPACITY; }
    public int size()        { return size; }
    /** Insert at index (0..size). Shifts elements right: O(n). */
    public boolean insert(int index, int value) {
        if (isFull()) { System.out.println("Array is full (capacity " + CAPACITY + ")."); return false; }
        if (index < 0 || index > size) { System.out.println("Invalid index. Valid range: 0 to " + size + "."); return false; }
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = value;
        size++;
        return true;
    }
 
    /** Delete at index. Shifts elements left: O(n). */
    public boolean deleteAt(int index) {
        if (isEmpty()) { System.out.println("Array is empty. Nothing to delete."); return false; }
        if (index < 0 || index >= size) { System.out.println("Invalid index. Valid range: 0 to " + (size - 1) + "."); return false; }
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--;
        return true;
    }
/** Linear search for a value; returns index or -1. */
    public int search(int value) {
        for (int i = 0; i < size; i++) if (data[i] == value) return i;
        return -1;
    }
 
    public void display() {
        if (isEmpty()) { System.out.println("Array is empty."); return; }
        StringBuilder sb = new StringBuilder("Array (size " + size + "/" + CAPACITY + "): [");
        for (int i = 0; i < size; i++) sb.append(data[i]).append(i < size - 1 ? ", " : "");
        System.out.println(sb.append("]"));
    }
public void menu() {
        int c;
        do {	
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert at end\n2. Insert at index\n3. Delete at index\n4. Delete by value");
            System.out.println("5. Search for value\n6. Display array\n7. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ", 1, 7);
            switch (c) {
                case 1 -> {
                    int v = InputHelper.readInt("Value: ");
                    if (insert(size, v)) { System.out.println("Inserted " + v + "."); PerformanceAnalyzer.log("Array insert end: " + v); }
                }
                case 2 -> {
                    int idx = InputHelper.readInt("Index: ");
                    int v = InputHelper.readInt("Value: ");
                    if (insert(idx, v)) { System.out.println("Inserted " + v + " at " + idx + "."); PerformanceAnalyzer.log("Array insert at " + idx + ": " + v); }
                }
                case 3 -> {
                    int idx = InputHelper.readInt("Index to delete: ");
                    if (deleteAt(idx)) { System.out.println("Deleted element at index " + idx + "."); PerformanceAnalyzer.log("Array delete index " + idx); }
                }
                case 4 -> {
                    if (isEmpty()) { System.out.println("Array is empty."); break; }
                    int v = InputHelper.readInt("Value to delete: ");
                    int idx = search(v);
                    if (idx == -1) System.out.println("Value not found.");
                    else { deleteAt(idx); System.out.println("Deleted " + v + "."); PerformanceAnalyzer.log("Array delete value " + v); }
                }
                case 5 -> {
                    int v = InputHelper.readInt("Value to search: ");
                    int idx = search(v);
                    String r = idx == -1 ? "Value " + v + " not found." : "Value " + v + " found at index " + idx + ".";
                    System.out.println(r);
                    PerformanceAnalyzer.log("Array search: " + r);
                }
                case 6 -> display();
                default -> { }
            }
        } while (c != 7);
    }

}
