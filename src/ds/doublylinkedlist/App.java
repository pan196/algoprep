package ds.doublylinkedlist;

public class App {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertFirst(22);
        myList.insertFirst(44);
        myList.insertFirst(66);
        myList.insertLast(11);
        myList.insertLast(33);
        myList.insertLast(55);
        myList.displayForward();
        myList.displayBackward();
        myList.deleteFirst();
        myList.deleteLast();
        myList.deleteKey(11);
        myList.displayForward();
        myList.insertAfter(22, 77);
        myList.insertAfter(33, 88);
        myList.displayForward();
    }
}
