package basic2;

public class TestStack {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>(2);
        stack.push(4);
        stack.push(5);
//        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isFull());
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
    }

}
