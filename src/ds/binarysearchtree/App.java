package ds.binarysearchtree;

public class App {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(53, "Fifty three");
        tree.insert(28, "Twenty eight");
        tree.insert(62, "Sixty two");
        tree.insert(10, "Ten");
        tree.insert(29, "Twenty nine");
        tree.insert(55, "Fifty five");
        tree.insert(100, "One hundred");
        tree.insert(99, "Ninety nine");
        tree.insert(98, "Ninety eight");
        tree.insert(101, "One hundred and one");
        tree.insert(150, "One hundred and fifty");
        tree.insert(9, "Nine");
        tree.insert(30, "Thirty");
        tree.insert(19, "Nineteen");

        tree.remove(62);

        System.out.println(tree.find(53).rightChild.value);
        System.out.println(tree.findMin().value);
        System.out.println(tree.findMax().value);
    }
}
