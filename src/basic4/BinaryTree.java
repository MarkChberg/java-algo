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


    // 最为繁复的删除方法
    // 1。对于leaf节点，将父引用指向为null即可
    // 2。对于一个子节点的节点， 将父引用指向子节点的下一个引用
    // 3。对于两个子节点的节点 寻找到中序后继节点
    public boolean removeNode(T value) {
        TreeNode<T> current = root;
        TreeNode<T> parent = root;
        boolean isLeft = true;
        while(!current.data.equals(value)) {
            parent = current;
            if (value.compareTo(current.data) > 0) {
                current = current.right;
                isLeft = false;
            } else {
                current = current.left;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.right == null && current.left == null) {
            if (current == root) {
                root = null;
            }
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (current.left == null) {
            if (current == root) {
                root = root.right;
            }
            if (isLeft) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }
        else if (current.right == null) {
            if (current == root) {
                root = root.left;
            }
            if (isLeft) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }
        else {
            TreeNode<T> successor = this.removeTwiNode(current);
            if (current == root) {
                successor.left = root.left;
                root = successor;
            }
            if(isLeft) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }

        }
        return true;
    }

    private TreeNode<T> removeTwiNode(TreeNode<T> delNode) {
        TreeNode<T> successParent = delNode;
        TreeNode<T> successor = delNode.right;
        while(successor.left != null) {
            successParent = successor;
            successor = successor.left; // 找到最小的替换者
        }
        if (successor == delNode.right) {
            successParent.right = null;
            successor.left = successParent.left;
        } else {
            successParent.left = null;
            successor.right = delNode.right;
            successor.left = delNode.left;
        }
        return successor;
    }
}
