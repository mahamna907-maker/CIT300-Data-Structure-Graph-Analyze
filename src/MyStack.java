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
    
    public void menu() {
        int c;
        do {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (c) {
                case 1 -> {
                    int v = InputHelper.readInt("Value to push: ");
                    if (push(v)) { System.out.println("Pushed " + v + "."); PerformanceAnalyzer.log("Stack push: " + v); }
                }
                case 2 -> {
                    if (isEmpty()) System.out.println("Stack underflow! Cannot pop from an empty stack.");
                    else { int v = pop(); System.out.println("Popped " + v + "."); PerformanceAnalyzer.log("Stack pop: " + v); }
                }
                case 3 -> {
                    if (isEmpty()) System.out.println("Stack is empty. Nothing to peek.");
                    else System.out.println("Top element: " + peek());
                }
                case 4 -> display();
                default -> { }
            }
        } while (c != 5);
    }
}
