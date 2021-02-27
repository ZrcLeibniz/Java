package zrc.course.algorithm9;

import java.util.Stack;

// 不使用任何额外空间，逆序一个栈
public class ReverseStack {
    public void solution(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = process(stack);
        solution(stack);
        stack.push(i);
    }

    private int process(Stack<Integer> stack) {
        int cur = stack.pop();
        if (stack.isEmpty()) {
            return cur;
        } else {
            int last = process(stack);
            stack.push(cur);
            return last;
        }
    }
}
