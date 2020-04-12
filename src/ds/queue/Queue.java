package ds.queue;

public class Queue {
    private int maxSize; // initializes the set number of slots

    private long[] queArray; // slots to main the data

    private int front; // the index position for the element in the front

    private int rear; // the index position of the element in the back

    private int nItems; // counter to maintain the number of items in the queue

    public Queue(int size) {
        this.maxSize = size;
        this.queArray = new long[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long i) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        rear++;
        queArray[rear] = i;
        nItems++;
    }

    /**
     * Remove item from the front of the queue
     * @return removed value
     */
    public long remove() {
        long temp = queArray[front];
        front++;
        if (front == maxSize) {
            front = 0; // reinitialize the array when the queue ends
        }
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public void view() {
        System.out.print("[ ");
        for (long l : queArray) {
            System.out.print(l + " ");
        }
        System.out.print("]");
    }
}
