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


    public void frontOrder(TreeNode<T> root) { // 递归两大难点，一是总结出变量，而是判断弹出条件（if）
        TreeNode<T> current = root;
        if(current != null) {
            System.out.print(root.data + " ");
            // left
            frontOrder(root.left);
            // right
            frontOrder(root.right);
        }
    }

    public void midOrder(TreeNode<T> root) {
        if(root != null) {
            // left
            midOrder(root.left);
            System.out.print(root.data + " ");
            // right
            midOrder(root.right);
        }
    }


    public void lastOrder(TreeNode<T> root) {
        if (root != null) {
            //left
            lastOrder(root.left);
            //right
            lastOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
