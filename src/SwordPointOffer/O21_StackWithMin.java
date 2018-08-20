package SwordPointOffer;

import java.util.Stack;

public class O21_StackWithMin {
    private final Stack<Integer> data = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        data.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));

    }

    public void pop() {
        data.pop();
        minStack.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
