package ds.heap;

import java.util.Arrays;

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

    /**
     * Default render implementation
     */
    public void render() {
        this.render("console");
    }

    /**
     * Renders the heap
     * @param option method of rendering (supported methods: console)
     */
    public void render(String option) {
        switch (option) {
            case "console":
            default:
                consoleRender();
        }
    }

    /**
     * Renders the tree in the console
     */
    private void consoleRender() {
        // Get the number of levels
        if (this.currentSize == 0) {
            return;
        }
        int levels = (int)(Math.log(this.currentSize) / Math.log(2)) + 1;;
        // Get the row length
        int rowLength = (int)(Math.pow(2, levels-1) * 2) - 1;

        for (int i = 1; i <= levels; i++) {
            // Number of nodes per level
            int rowFullCells = (int)Math.pow(2, i-1);
            // Container for node indexes for that level
            int filledRowIndexes[] = new int[rowFullCells];
            // Each row starts with N empty cells
            // If the levels are 4
            // 1st level will have 7 empty starting blocks
            // 2nd - 3
            // 3rd - 1
            // 4th - 0
            int rowBlockEmptyCells = (int)Math.floor(rowLength / Math.pow(2, i));

            // Using the starting empty slots to calculate filled indexes
            for (int j = 0; j < rowFullCells; j++) {
                if (j == 0) {
                    filledRowIndexes[j] = j + rowBlockEmptyCells;
                } else {
                    filledRowIndexes[j] = filledRowIndexes[j-1] + (rowBlockEmptyCells * 2) + 2;
                }
            }

            // Setting current cell to 0 index
            int currentRowIndex = 0;
            while (currentRowIndex < rowLength) {
                // Rendering current cell
                this.renderCell(i, currentRowIndex, filledRowIndexes);
                // Increasing cell index
                currentRowIndex++;
            }
            // Print new line for the next level
            System.out.println();
        }
    }

    /**
     * Renders the current cell in the row
     * @param row tree level
     * @param index index to render
     * @param filledRowIndexes array with non empty indexes
     */
    private void renderCell(int row, int index, int[] filledRowIndexes) {
        // Get the position of the current node-to-render
        int nodePos = Arrays.binarySearch(filledRowIndexes, index);

        if (nodePos > -1) {
            if (filledRowIndexes.length == 1) {
                // If the filled row index per current is a single one - render root
                System.out.print(" " + this.heapArray[0].getKey() + " ");
            } else {
                String keyToPrint = this.printKeyByRowPos(row, nodePos);
                // Render node value or "--" if no node is inserted in the position
                System.out.print(" " + keyToPrint + " ");
            }
        } else {
            // If the there is no node on the position - render empty element
            System.out.print("    ");
        }
    }

    /**
     * Returns node key or "--" if no node is inserted on that position
     * @param row tree level
     * @param nodePos the position of the node in the tree level
     * @return node key or "--" if no node is inserted on that position
     */
    private String printKeyByRowPos(int row, int nodePos) {
        // Get the indexes before starting of the current level
        int headingIndexes = (int)Math.pow(2, row-1) - 1;
        // Get the index of the current node in the heap
        int positionInHeap = headingIndexes + nodePos;

        if (positionInHeap >= this.currentSize) {
            // If current node exceeds current size - render placeholder
            return "--";
        } else {
            // If current node is in the range of current size - render it's key
            return Integer.toString(this.heapArray[positionInHeap].getKey());
        }
    }
}
