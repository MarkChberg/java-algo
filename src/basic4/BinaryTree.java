package basic4;

public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;


    public void addNode(T value) {
        TreeNode<T> node = new TreeNode<>(value);
        if (root == null) {
            root = node;
        } else {
            TreeNode<T> current = root;
            TreeNode<T> parent;
            while(current != null) {
                parent = current;
                if (value.compareTo(current.data) > 0) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                    }
                } else {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                    }
                }
            }
        }
    }

    public TreeNode<T> findNode(T value) {
        TreeNode<T> current = root;

        while(current != null && !current.data.equals(value)) {
            if (value.compareTo(current.data) > 0) {
                // find in the right tree
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return current;
    }
}
