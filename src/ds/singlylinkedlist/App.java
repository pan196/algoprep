package ds.singlylinkedlist;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.insertFirst(100);
        myList.insertLast(111);
        myList.insertFirst(50);
        myList.insertFirst(542);
        myList.insertLast(242);
        myList.insertFirst(542);
        myList.displayList();
    }
}
