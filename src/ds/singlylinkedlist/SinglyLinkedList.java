package ds.singlylinkedlist;

import ds.linkedlist.Node;

public class SinglyLinkedList {
    private Node first;

    public SinglyLinkedList() {

    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Insert the beginning of the list
     * @param data value of the new first node
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.setNext(first);
        this.first = newNode;
    }

    public void insertLast(int data) {
        Node current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        Node newNode = new Node(data);
        current.setNext(newNode);
    }

    public Node deleteFirst() {
        Node temp = first;
        first = first.getNext();
        return temp;
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
