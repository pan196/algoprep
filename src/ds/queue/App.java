package ds.queue;

public class App {
    public static void main(String[] args) {
        Queue myQueue = new Queue(4);
        myQueue.insert(5);
        myQueue.insert(15);
        myQueue.insert(25);
        myQueue.insert(-55);
        myQueue.insert(-535);

        myQueue.view();
    }
}
