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
    
    /** Returns popped value; callers must check isEmpty first. */
    public int pop() { return items[top--]; }

    public int peek() { return items[top]; }

    public void display() {
        if (isEmpty()) { System.out.println("Stack is empty."); return; }
        System.out.println("Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) System.out.println("  | " + items[i] + " |" + (i == top ? "  <- top" : ""));
        System.out.println("  +----+");
    }
}
