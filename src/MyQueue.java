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
}