package ds.stack;

public class Stack {
    private int maxSize;

    private char[] stackArray;

    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j) {
        if (this.isFull()) {
            System.out.println("Stack is already full! You can't add elements.");
        } else {
            top++;
            stackArray[top] = j;
        }
    }

    public char pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty! You can't pop elements.");
            return '0';
        } else {
            int oldTop = top;
            top--;
            return stackArray[oldTop];
        }
    }

    public char peak() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (maxSize - 1 == top);
    }
}
