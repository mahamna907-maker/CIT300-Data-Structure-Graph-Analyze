/** Fixed-capacity array with insert, delete, search and display. */
public class ArrayOperations {
    public static final int CAPACITY = 20;
    private final int[] data = new int[CAPACITY];
    private int size = 0;
 
    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == CAPACITY; }
    public int size()        { return size; }
}
