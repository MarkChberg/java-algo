package basic2;

public class TestBiLinkedNode {

    public static void main(String[] args) {
        BiLinkedNode nodes = new BiLinkedNode();

        nodes.addFirst(new Node<>(8));
        nodes.addFirst(new Node<>(9));

        nodes.display();

        nodes.addLast(new Node<>(10));

        nodes.display();

        nodes.insertNode(2, new Node<>(6));
        nodes.display();

        nodes.removeNode(6);
        nodes.display();
    }
}
