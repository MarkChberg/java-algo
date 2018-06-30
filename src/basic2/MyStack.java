package basic2;

public class MyStack<T> implements Stack<T> {

    private int top = -1;

    private Object[] arr;

    private int totalNumber = 0;

    public MyStack(int length) {
        this.arr = new Object[length];
    }

    public MyStack() {
        this.arr = new Object[5];
    }

    @Override
    public void push(T element) {
        if (!isFull()) {
            arr[++top] = element;
            totalNumber++;
        } else throw new IllegalCallerException("this stack is full");
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            totalNumber--;
            return (T)arr[top--];
        } else throw new IllegalCallerException("this stack has no elements");
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return (T)arr[top];
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return totalNumber == 0;
    }

    @Override
    public boolean isFull() {
        return totalNumber == arr.length;
    }
}
