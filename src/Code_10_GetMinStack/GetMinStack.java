package Code_10_GetMinStack;

import java.util.Stack;

public class GetMinStack {

    private final Stack<Integer> dataStack;
    private final Stack<Integer> minStack;

    public GetMinStack() {
        dataStack = new Stack<>();
        minStack  = new Stack<>();
    }

    public void push(int num) {
        dataStack.push(num);
        if (!minStack.isEmpty() && minStack.peek() < num) {
            minStack.push(minStack.peek());
        } else {
            minStack.push(num);
        }
    }

    public int pop() {
        minStack.pop();
        return dataStack.pop();
    }

    public int getMin() {
        return minStack.peek();
    }


}
