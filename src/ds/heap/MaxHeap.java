package ds.heap;

/**
 * MaxHeap data structure
 */
public class MaxHeap {
    private Node[] heapArray;
    // Size of the array
    private int maxSize;
    // Number of nodes in the array
    private int currentSize;

    /**
     * MaxHeap constructor
     * @param size of the array
     */
    public MaxHeap(int size) {
        this.maxSize = size;
        this.currentSize = 0;
        // Creating of the array
        this.heapArray = new Node[size];
    }

    /**
     * Get heap size
     * @return size of the heap array
     */
    public int getSize() {
        return this.currentSize;
    }

    /**
     * Check if array is empty
     * @return boolean if the array is empty
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    /**
     * Insert new value into heap array
     * @param key value to insert
     * @return whether insertion succeeded or not
     */
    public boolean insert(int key) {
        if (this.currentSize == this.maxSize) {
            // Array is full
            return false;
        }

        // Create the new node
        Node newNode = new Node(key);
        // Add the new node to the last position
        this.heapArray[this.currentSize] = newNode;

        int nodeIndex = currentSize;
        // Get the parent node
        int parentIndex = (nodeIndex - 1) / 2;
        // Keep moving new node to upper position until it's <= than its parent and >= than it's children
        while (nodeIndex > 0 && this.heapArray[nodeIndex].getKey() > this.heapArray[parentIndex].getKey()) {
            Node temp = this.heapArray[parentIndex];
            this.heapArray[parentIndex] = this.heapArray[nodeIndex];
            this.heapArray[nodeIndex] = temp;
            nodeIndex = parentIndex;
            parentIndex = (nodeIndex - 1) / 2;
        }
        this.currentSize++;

        return true;
    }

    /**
     * Remove first value from tha heap array
     * @return removed node or null
     */
    public Node remove() {
        if (this.isEmpty() == true) {
            // Array is empty
            return null;
        }

        int newIndex = 0;
        // Assign the removed node to variable
        Node removedNode = this.heapArray[newIndex];
        // Set the last child in place of the first node
        this.heapArray[newIndex] = this.heapArray[this.currentSize - 1];
        // Decrease the size of the heap array
        this.currentSize--;

        // Get the index of the biggest child
        int maxChildIndex = this.getMaxChildIndex(newIndex);
        // Iterate while the child is bigger than the new root until it get's to proper position
        while (newIndex <= this.currentSize &&
                this.heapArray[maxChildIndex].getKey() > this.heapArray[newIndex].getKey()) {

            Node temp = this.heapArray[maxChildIndex];
            this.heapArray[maxChildIndex] = this.heapArray[newIndex];
            this.heapArray[newIndex] = temp;
            newIndex = maxChildIndex;
            maxChildIndex = this.getMaxChildIndex(newIndex);
        }

        return removedNode;
    }

    /**
     * Helper method for the remove
     * allows to get the index of the biggest child
     * @param index of the parent
     * @return index of the biggest child
     */
    private int getMaxChildIndex(int index) {
        // Index of left child
        int lcIndex = (2 * index) + 1;
        // Index of right child
        int rcIndex = lcIndex + 1;
        // Init max child index
        int maxChildIndex = -1;
        if (this.heapArray[rcIndex].getKey() > this.heapArray[lcIndex].getKey()) {
            // Max child is the right child
            maxChildIndex = rcIndex;
        } else {
            // Max child is the left child
            maxChildIndex = lcIndex;
        }
        return maxChildIndex;
    }

    public void render() {
        System.out.println();
        for (int i = 0; i < this.currentSize; i++) {
            Node node = heapArray[i];
            System.out.println(node.getKey());
        }
        System.out.println();
    }
}
