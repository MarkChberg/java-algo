package basic2;

import java.util.Objects;

public class MyLinkedNode extends LinkedNode<Integer> {


    @Override
    public void addFirst(Node<Integer> ele) {
        if(Objects.isNull(first)) {
            first = ele;
        } else {
            ele.next = first.next;
            first.next = ele;
        }
    }

    @Override
    public void addLast(Node<Integer> ele) {

    }

    @Override
    public Node<Integer> getNode(Integer value) {
        Node<Integer> current = first;
        while(Objects.nonNull(current)) {
            if (current.date.equals(value)) {
                return current;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    @Override
    public Node<Integer> removeNode(Integer value) {
        Node<Integer> current = first;
        Node<Integer> prev = first;
        while(Objects.nonNull(current)) {
            if (current.date.equals(value)) {
                prev.next = current.next;
                return current;
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        return current;
    }

    @Override
    public Node<Integer> getNode(int position) {
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
            return;
        }
        Node<Integer> current = first;
        Node<Integer> prev = first;
        while(position-- > 0) {
            prev = current;
            current = current.next;
        }
        prev.next = node;
        node.next = current;
    }

    @Override
    public void display() {
        Node<Integer> current = first;
        while (Objects.nonNull(current)) {
            System.out.print(current.date + ",");
            current = current.next;
        }
    }
}
