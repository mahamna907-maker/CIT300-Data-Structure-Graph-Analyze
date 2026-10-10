/** Circular-array FIFO queue with overflow/underflow handling. */
public class MyQueue {
    private static final int CAPACITY = 10;
    private final int[] items = new int[CAPACITY];
    private int front = 0, count = 0;

    public boolean isEmpty() { return count == 0; }
    public boolean isFull()  { return count == CAPACITY; }

    public boolean enqueue(int v) {
        if (isFull()) { System.out.println("Queue overflow! Queue is full (capacity " + CAPACITY + ")."); return false; }
        items[(front + count) % CAPACITY] = v;
        count++;
        return true;
    }
    
    /** Returns removed value; callers must check isEmpty first. */
    public int dequeue() {
        int v = items[front];
        front = (front + 1) % CAPACITY;
        count--;
        return v;
    }

    public int front() { return items[front]; }

    public void display() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        StringBuilder sb = new StringBuilder("Front -> ");
        for (int i = 0; i < count; i++) sb.append("[").append(items[(front + i) % CAPACITY]).append("] ");
        System.out.println(sb.append("<- Rear"));
    }
    
    public void menu() {
        int c;
        do {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek/Front\n4. Display\n5. Return to Main Menu");
            c = InputHelper.readInt("Enter your choice: ", 1, 5);
            switch (c) {
                case 1 -> {
                    int v = InputHelper.readInt("Value to enqueue: ");
                    if (enqueue(v)) { System.out.println("Enqueued " + v + "."); PerformanceAnalyzer.log("Queue enqueue: " + v); }
                }
                case 2 -> {
                    if (isEmpty()) System.out.println("Queue underflow! Cannot dequeue from an empty queue.");
                    else { int v = dequeue(); System.out.println("Dequeued " + v + "."); PerformanceAnalyzer.log("Queue dequeue: " + v); }
                }
                case 3 -> {
                    if (isEmpty()) System.out.println("Queue is empty. Nothing at the front.");
                    else System.out.println("Front element: " + front());
                }
                case 4 -> display();
                default -> { }
            }
        } while (c != 5);
    }
}