package rich.zrc.stackorqueue;

import org.junit.Test;

import java.util.Stack;

public class NoHelpReverseStackTest {
    @Test
    public void test() {
        NoHelpReverseStack util = new NoHelpReverseStack();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
        util.reverseStack(stack);
        System.out.println();
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
    }
}
