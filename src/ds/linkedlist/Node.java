package ds.linkedlist;

public class Node {
    private int data;
    private Node next;
    private Node previous;

    public Node(int value) {
        this.data = value;
        this.next = null;
        this.previous = null;
    }

    public int getData() {
        return this.data;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }

    public Node getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void setPrevious(Node previousNode) {
        this.previous = previousNode;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public boolean hasPrevious () {
        return this.previous != null;
    }

    public void displayNode() {
        System.out.print("{ " + this.data + " } ");
    }
}
