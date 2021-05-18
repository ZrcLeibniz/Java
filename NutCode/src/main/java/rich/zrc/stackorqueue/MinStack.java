package rich.zrc.stackorqueue;

import java.util.Stack;

/*
    设计一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
        } else {
            if (minStack.peek() > x) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
            stack.push(x);
        }
    }

    public int poll() {
        Integer pop = stack.pop();
        minStack.pop();
        return pop;
    }

    public int getMin() {
        return minStack.peek();
    }
}
