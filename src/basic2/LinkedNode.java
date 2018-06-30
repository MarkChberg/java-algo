package basic2;


/**
 * 一个双端双向链表的抽象类
 * @param <T>
 */
public abstract class LinkedNode<T> {

    protected Node<T> first; // first element

    protected Node<T> last;  // last element

    public abstract void addFirst(Node<T> ele); // insert node after the first

    public abstract void addLast(Node<T> ele); // insert node at the last of LinkedNode

    public abstract Node<T> getNode(T value); // get specific element according to the value

    public abstract Node<T> removeNode(T value); // remove the Node

    public abstract Node<T> getNode(int position); // get specific element according to the position

    public abstract void insertNode(int position, Node<T> node); // insert the node at the specific position

    public abstract void display(); // display the all Node data-field

}
