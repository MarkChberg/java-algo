package basic2;


// Node节点的基本结构
public class Node<T> {

    public Node<T> prev;

    public T date;

    public Node<T> next;

    public Node(T date) {
        this.date = date;
    }
}
