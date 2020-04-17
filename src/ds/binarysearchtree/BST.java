package ds.binarysearchtree;

import java.util.Arrays;

/**
 * Binary search tree implementation
 */
public class BST {
    /**
     * The root node of the tree
     */
    private Node root;

    /**
     * Inserts a node in the tree
     * @param key integer key of the new node
     * @param value string value of the new node
     */
    public void insert(int key, String value) {
        // Create actual node from provided values
        Node newNode = new Node(key, value);
        if (this.root == null) {
            // The new node is actually the first node in the tree
            this.root = newNode;
        } else {
            Node current = root;
            Node parent;

            // This while loop will break when newNode is inserted as new leaf
            while (true) {
                parent = current;
                if (key <= current.key) {
                    // If new key is <= of the current node key - continue LEFT
                    current = current.leftChild;
                    if (current == null) {
                        // The parent is the leaf
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    // If new key is > of the current node key - continue RIGHT
                    current = current.rightChild;
                    if (current == null) {
                        // The parent is the leaf
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * Remove node by search criteria
     * @param key search criteria for the node to be removed
     * @return true if the node is found and deleted and false otherwise
     */
    public boolean remove(int key) {
        // Find the node or return false
        Node searchedNode = this.find(key);
        // If no such node found - return false
        if (searchedNode == null) {
            return false;
        }
        // Get the parent node of the searched one
        Node parentNode = this.findParent(key);

        if (searchedNode.leftChild == null &&
                searchedNode.rightChild == null && parentNode != null) {
            // Check if the node is leaf
            if (searchedNode == root) {
                root = null;
            } else if (searchedNode.key < parentNode.key) {
                parentNode.leftChild = null;
            } else {
                parentNode.rightChild = null;
            }
            return true;
        } else if (searchedNode.leftChild == null) {
            // If not - check if the node has only right children
            if (searchedNode == root) {
                root = searchedNode.rightChild;
            } else {
                assert parentNode != null;
                if (searchedNode.key < parentNode.key) {
                    parentNode.leftChild = searchedNode.rightChild;
                } else {
                    parentNode.rightChild = searchedNode.rightChild;
                }
            }
            return true;
        } else if (searchedNode.rightChild == null) {
            // If not - check if the node has only left children
            if (searchedNode == root) {
                root = searchedNode.leftChild;
            } else {
                assert parentNode != null;
                if (searchedNode.key < parentNode.key) {
                    parentNode.leftChild = searchedNode.leftChild;
                } else {
                    parentNode.rightChild = searchedNode.leftChild;
                }
            }
            return true;
        } else {
            // If not - find the smallest child node on the right and replace the deleted node with it
            Node replaceCandidate = this.findReplaceCandidate(searchedNode.rightChild);
            // Find the replace candidate parent as it's child should be removed
            Node smallestParent = this.findParent(replaceCandidate.key);

            // Set new relations of candidate parent node
            assert smallestParent != null;
            if (smallestParent.leftChild == replaceCandidate) {
                smallestParent.leftChild = null;
            } else {
                smallestParent.rightChild = null;
            }

            // Set new relations of the replace candidate itself
            replaceCandidate.leftChild = searchedNode.leftChild;
            replaceCandidate.rightChild = searchedNode.rightChild;
            // Set the replace candidate itself
            if (searchedNode == root) {
                root = replaceCandidate;
            } else {
                assert parentNode != null;
                if (searchedNode.key < parentNode.key) {
                    parentNode.leftChild = replaceCandidate;
                } else {
                    parentNode.rightChild = replaceCandidate;
                }
            }
            return true;
        }
    }

    /**
     * Finds the smallest node in the tree
     * @return the smallest node in the tree
     */
    public Node findMin() {
        // Start from the root node
        Node current = root;
        Node last = null;

        // Loop until we have no children nodes
        while (current != null) {
            // Keeping the last as smallest node - potential result
            last = current;

            // Always take the left node as <= than parent
            current = current.leftChild;
        }

        return last;
    }

    /**
     * Finds the largest node in the tree
     * @return the largest node in the tree
     */
    public Node findMax() {
        // Start from the root node
        Node current = root;
        Node last = null;

        while (current != null) {
            // Keeping the last as largest node - potential result
            last = current;

            // Always take the left node as > than parent
            current = current.rightChild;
        }

        return last;
    }

    /**
     * Find node in the tree by provided key
     * @param key search criteria
     * @return Node matching the search criteria or null
     */
    public Node find(int key) {
        // Start from the root node
        Node current = root;

        while (true) {
            if (current.key == key) {
                // If match found - exit
                return current;
            } else if (key < current.key) {
                if (current.leftChild == null) {
                    // If no match found - break
                    return null;
                }
                // Continue with the left child
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    // If no match found - break
                    return null;
                }
                // Continue with the right child
                current = current.rightChild;
            }
        }
    }

    /**
     * Find parent of node by provided key
     * @param key search criteria
     * @return parent Node of the node matching hte criteria or null
     */
    private Node findParent(int key) {
        // Start from the root node
        Node current = this.root;
        Node parent = null;

        while (true) {
            if (current.key == key) {
                // If match found - exit with parent
                return parent;
            } else if (key < current.key) {
                if (current.leftChild == null) {
                    // If no match found - break
                    return null;
                }
                // Assign the current parent
                parent = current;
                // Continue with the left child
                current = current.leftChild;
            } else {
                parent = current;
                if (current.rightChild == parent) {
                    // If no match found - break
                    return null;
                }
                // Assign the current parent
                parent = current;
                // Continue with the right child
                current = current.rightChild;
            }
        }
    }

    /**
     * On the remove procedure if the deleted node has more than one
     * child - the smallest larger element should be found as
     * replace candidate
     * @param node right child of the node-to-replace
     * @return the elected candidate that will go on the vacant position
     */
    private Node findReplaceCandidate(Node node) {
        // Start from the node-to-replace right child
        Node current = node;
        Node last = null;

        // Loop until we have no children nodes
        while (current != null) {
            // Keeping the last as smallest node - potential result
            last = current;

            // Search on the left side for match
            current = current.leftChild;
        }

        return last;
    }

    /**
     * Renders the tree
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
        int levels = this.getLevels();
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
                System.out.print(" " + this.root.key + " ");
            } else {
                String keyToPrint = this.printKeyByRowPos(row, filledRowIndexes, nodePos);
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
     * @param filledIndexes array with non empty indexes
     * @param nodePos the position of the node in the array
     * @return node key or "--" if no node is inserted on that position
     */
    private String printKeyByRowPos(int row, int[] filledIndexes, int nodePos) {
        // Starting from the root node
        Node current = root;
        // Setting initial current row, start and end point in the array with indexes
        int currentRow = 1;
        int currentStart = 0;
        int currentEnd = filledIndexes.length-1;

        while (currentRow < row) {
            // Calculate the middle in order to navigate through the tree
            int mid = (currentStart + currentEnd) / 2;
            if (nodePos > mid) {
                // If node position is on the right side - we take the right child
                current = current.rightChild;
                // Moving currentStart on the right side of mid
                currentStart = mid+1;
            } else {
                // If node position is on the left side - we take the left child
                current = current.leftChild;
                // Moving currentEnd to equal the mid
                currentEnd = mid;
            }
            if (current == null) {
                // If the current become null - return no value
                return "--";
            }
            // Go to the next row
            currentRow++;
        }

        // Return the key of the current node
        return Integer.toString(current.key);
    }

    /**
     * Tree levels
     * @return number of levels of the whole tree
     */
    public int getLevels() {
        return this.getLevels(this.root);
    }

    /**
     * Get levels starting form a node
     * @param n starting node
     * @return number of levels starting from the provided node
     */
    private int getLevels(Node n) {
        // If no node is provided return 0
        if (n == null) {
            return 0;
        }

        // Recursively count left from the provided node
        int leftHeight = this.getLevels(n.leftChild);
        // Recursively count right from the provided node
        int rightHeight = this.getLevels(n.rightChild);

        if (leftHeight > rightHeight) {
            // Increase left route
            return leftHeight + 1;
        } else {
            // Increase right route
            return rightHeight + 1;
        }
    }
}
