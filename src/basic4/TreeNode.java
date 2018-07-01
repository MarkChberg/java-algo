package basic4;
// 一个二叉树的节点
public class TreeNode<T extends Comparable<T>> {

    public T data;

    public TreeNode<T> right;

    public TreeNode<T> left;

    public TreeNode(T data) {
        this.data = data;
    }
}
