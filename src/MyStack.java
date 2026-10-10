/** Array-based LIFO stack with overflow/underflow handling. */
public class MyStack {
    private static final int CAPACITY = 10;
    private final int[] items = new int[CAPACITY];
    private int top = -1;

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == CAPACITY - 1; }

    public boolean push(int v) {
        if (isFull()) { System.out.println("Stack overflow! Stack is full (capacity " + CAPACITY + ")."); return false; }
        items[++top] = v;
        return true;
    }
}
