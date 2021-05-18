package rich.zrc.stackorqueue;

import java.util.Stack;

/*
    使用两个栈来模拟一个队列
 */
public class TwoStackQueue {
    private Stack<Integer> stackI = new Stack<>();
    private Stack<Integer> stackII = new Stack<>();

    public void add(int x) {
        stackI.push(x);
    }

    public int peek() {
        if (stackII.isEmpty()) {
            reverse();
        }
        return stackII.peek();
    }

    public int poll() {
        if (stackII.isEmpty()) {
            reverse();
        }
        return stackII.pop();
    }

    private void reverse() {
        while (!stackI.isEmpty()) {
            stackII.push(stackI.pop());
        }
    }
}
