package ds.heap;

public class App {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(6);

        heap.insert(5);
        heap.insert(8);
        heap.insert(2);
        heap.insert(7);
        heap.insert(9);

        heap.render();

        Node removedNode = heap.remove();
        System.out.println(removedNode.getKey());

        heap.render();
    }
}
