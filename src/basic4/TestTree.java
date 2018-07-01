package basic4;

public class TestTree {

    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.addNode(4);
        bt.addNode(8);
        bt.addNode(3);
        bt.addNode(10);

        System.out.println(bt);

        TreeNode<Integer> node = bt.findNode(8);
        System.out.println(node);
    }
}
