package rich.zrc.stackorqueue;

import java.util.Stack;

/*
    不使用任何额外的变量或数据结构来逆序一个栈
 */
public class NoHelpReverseStack {
    private int getLast(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getLast(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getLast(stack);
        reverseStack(stack);
        stack.push(last);
    }
}
