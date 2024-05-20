package Code_11_StackAndQueueConvert;

import java.util.Stack;

public class TwoStacksQueue {

    private Stack<Integer> push;
    private Stack<Integer> pop;

    public TwoStacksQueue() {
        push = new Stack<>();
        pop  = new Stack<>();
    }

    public void push(int num) {
        push.push(num);
    }

    public Integer poll() {
        if (push.isEmpty()) {
            return null;
        }
        while (!push.isEmpty()) {
            pop.push(push.pop());
        }
        int number = pop.pop();
        while (!pop.isEmpty()) {
            push.push(pop.pop());
        }
        return number;
    }

    public Integer peek() {
        if (push.isEmpty()) {
            return null;
        }
        while (!push.isEmpty()) {
            pop.push(push.pop());
        }
        int number = pop.peek();
        while (!pop.isEmpty()) {
            push.push(pop.pop());
        }
        return number;
    }

}
