package ds.heap;

/**
 * Node class. Used for heap DS implementation
 */
public class Node {
    private int key;

    /**
     * Node constructor
     * @param key integer value
     */
    public Node(int key) {
        this.key = key;
    }

    /**
     * Get key
     * @return key value of the node
     */
    public int getKey() {
        return key;
    }

    /**
     * Set key
     * @param key
     */
    public void setKey(int key) {
        this.key = key;
    }
}
