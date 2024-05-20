package Code_11_StackAndQueueConvert;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈结构
 */
public class TwoQueuesStack {

    private Queue<Integer> data;
    private Queue<Integer> help;

    public TwoQueuesStack() {
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    //入栈
    public void push(int number) {
        data.add(number);
    }

    //查看栈顶元素
    public Integer peek() {
        if (data.isEmpty()) {
            return null;
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int number = data.poll();
        help.add(number);
        swap();
        return number;
    }

    //弹出栈顶元素
    public Integer pop() {
        if (data.isEmpty()) {
            return null;
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int number = data.poll();
        swap();
        return number;
    }

    private void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }

}
