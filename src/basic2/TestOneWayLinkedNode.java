package basic2;

public class TestOneWayLinkedNode {

    public static void main(String[] args) {
        MyLinkedNode nodes = new MyLinkedNode();

        nodes.addFirst(new Node<>(5));
        nodes.addFirst(new Node<>(6));
        nodes.addFirst(new Node<>(9));

        nodes.display();

        System.out.println();
        nodes.removeNode(6);
        nodes.display();

        System.out.println();
        Node<Integer> node = nodes.getNode(0);
        System.out.println(node.date);

        System.out.println();
        nodes.insertNode(1, new Node<>(4));
        nodes.display();
    }
}
