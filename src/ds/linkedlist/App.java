package ds.linkedlist;

public class App {
    public static void main(String[] args) {
        Node nodeA = new Node(4);
        Node nodeB = new Node(3);
        nodeA.setNext(nodeB);
        Node nodeC = new Node(7);
        nodeB.setNext(nodeC);
        Node nodeD = new Node(8);
        nodeC.setNext(nodeD);

        System.out.println(listLength(nodeA));
        System.out.println(listLength(nodeB));
    }

    public static int listLength(Node aNode) {
        int result = 1;
        while (aNode.hasNext()) {
            result++;
            aNode = aNode.getNext();
        }
        return result;
    }
}
