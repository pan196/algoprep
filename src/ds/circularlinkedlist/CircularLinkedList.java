package ds.circularlinkedlist;

import ds.linkedlist.Node;

public class CircularLinkedList {
    private Node first;
    private Node last;

    public CircularLinkedList() {
        this.first = null;
        this.last = null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.last = newNode;
        }
        newNode.setNext(first);
        this.first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
    }

    public int deleteFirst() {
        int temp = this.first.getData();

        if (first.getNext() == null) {
            this.last = null;
        }

        this.first = this.first.getNext();

        return temp;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void displayList() {
        System.out.println("List (first --> last) ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.getNext();
        }
    }
}
