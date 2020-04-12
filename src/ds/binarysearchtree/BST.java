package ds.binarysearchtree;

public class BST {
    private Node root;

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key <= current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        // The parent is the leaf
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
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

    public Node findMin() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax() {
        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    private Node findSmallestLarger(Node node) {
        Node current = node;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public boolean remove(int key) {
        // Find the node or return false
        Node searchedNode = this.find(key);
        if (searchedNode == null) {
            return false;
        }
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
            // If not - find the smallest child node and replace the deleted node with it
            Node smallestChild = this.findSmallestLarger(searchedNode.rightChild);
            Node smallestParent = this.findParent(smallestChild.key);

            assert smallestParent != null;
            if (smallestParent.leftChild == smallestChild) {
                smallestParent.leftChild = null;
            } else {
                smallestParent.rightChild = null;
            }
            smallestChild.leftChild = searchedNode.leftChild;
            smallestChild.rightChild = searchedNode.rightChild;
            if (searchedNode == root) {
                root = smallestChild;
            } else {
                assert parentNode != null;
                if (searchedNode.key < parentNode.key) {
                    parentNode.leftChild = smallestChild;
                } else {
                    parentNode.rightChild = smallestChild;
                }
            }
            return true;
        }
    }

    public Node find(int key) {
        Node current = root;

        while (true) {
            if (current.key == key) {
                return current;
            } else if (key < current.key) {
                if (current.leftChild == null) {
                    return null;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    return null;
                }
                current = current.rightChild;
            }
        }
    }

    private Node findParent(int key) {
        Node parent = null;
        Node current = this.root;

        while (true) {
            if (current.key == key) {
                return parent;
            } else if (key < current.key) {
                if (current.leftChild == null) {
                    return null;
                }
                parent = current;
                current = current.leftChild;
            } else {
                parent = current;
                if (current.rightChild == parent) {
                    return null;
                }
                parent = current;
                current = current.rightChild;
            }
        }
    }
}
