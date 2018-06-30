package basic2;

// 双向双端链表（双向表示Node除了next指针外还拥有prev指针，双端表示会引用最后一个node）
public class BiLinkedNode extends LinkedNode<Integer> {

    @Override
    public void addFirst(Node<Integer> ele) {
        if (first == null) {
            last = ele;
        } else {
            first.prev = ele;
            ele.next = first;
        }
        first = ele;
    }

    @Override
    public void addLast(Node<Integer> ele) {
        if (first == null) {
            first = ele;
        } else {
            last.next = ele;
            ele.prev = last;
        }
        last = ele;
    }

    @Override
    public Node<Integer> getNode(Integer value) {
        Node<Integer> current = first;
        while(current != null) {
            if (current.date.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return current;
    }

    @Override
    public Node<Integer> removeNode(Integer value) {
        Node<Integer> current = first;
        while(current != null) {
            if (current.date.equals(value)) {
                current.next.prev = current.prev;
                current.prev.next = current.next;
                return current;
            }
            current = current.next;
        }
        return current;
    }

    @Override
    public Node<Integer> getNode(int position) { // 与position有关的可以用last逆向遍历进行优化
        Node<Integer> current = first;
        while(position-- > 0) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void insertNode(int position, Node<Integer> node) {
        if (position == 0) {
            node.next = first;
            first = node;
        }
        Node<Integer> current = first;
        while(position-- > 0) {
            current = current.next;
        }
        current.prev.next = node;
        node.prev = current.prev;
        node.next = current;
        current.prev = node;
        node.next = current;
    }

    @Override
    public void display() {
        Node<Integer> current = first;
        while(current != null) {
            System.out.print(current.date + " ");
            current = current.next;
        }
        System.out.println();
    }
}
