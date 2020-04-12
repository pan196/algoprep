package ds.circularlinkedlist;

public class App {
    public static void main(String[] args) {
        CircularLinkedList myList = new CircularLinkedList();
        myList.insertFirst(100);
        myList.insertLast(111);
        myList.insertFirst(50);
        myList.insertFirst(542);
        myList.insertLast(242);
        myList.insertFirst(542);
        myList.displayList();
    }
}
