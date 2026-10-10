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
}