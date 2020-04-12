package ds.doublylinkedlist;

import ds.linkedlist.Node;

public class DoublyLinkedList {
    private Node first;
    private Node last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.last = newNode;
        } else {
            this.first.setPrevious(newNode);
        }

        newNode.setNext(this.first);
        this.first = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }

        newNode.setPrevious(this.last);
        this.last = newNode;
    }

    public Node deleteFirst() {
        Node temp = this.first;

        if (this.first.getNext() == null) {
            this.last = null;
        } else {
            this.first.getNext().setPrevious(null);
        }

        this.first = this.first.getNext();

        return temp;
    }

    public Node deleteLast() {
        Node temp = this.last;

        if (this.last.getPrevious() == null) {
            this.first = null;
        } else {
            this.last.getPrevious().setNext(null);
        }

        this.last = this.last.getPrevious();

        return temp;
    }

    public boolean insertAfter(int key, int data) {
        Node current = this.first;

        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return false;
            }
        }

        Node newNode = new Node(data);

        if (current == this.last) {
            current.setNext(null);
            last = newNode;
        } else {
            newNode.setNext(current.getNext());
            current.getNext().setPrevious(newNode);
        }

        newNode.setPrevious(current);
        current.setNext(newNode);
        return true;
    }

    public Node deleteKey(int key) {
        Node current = this.first;
        boolean hasKey = false;

        while (current.getData() != key) {
            current = current.getNext();
            if (current == null) {
                return null;
            }
        }

        if (current == this.first) {
            this.first = current.getNext();
        } else {
            current.getPrevious().setNext(current.getNext());
        }

        if (current == this.last) {
            this.last = current.getPrevious();
        } else {
            current.getNext().setPrevious(current.getPrevious());
        }

        return current;
    }

    public void displayForward() {
        System.out.print("List (first --> last) ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last --> first) ");
        Node current = last;
        while (current != null) {
            current.displayNode();
            current = current.getPrevious();
        }
        System.out.println();
    }
}
