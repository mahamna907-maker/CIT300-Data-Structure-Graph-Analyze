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

}
