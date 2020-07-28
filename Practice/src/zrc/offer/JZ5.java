package zrc.offer;

import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ5 {
    // 作为队列的入队栈
    Stack<Integer> stack1 = new Stack<Integer>();
    // 作为队列的出队栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        JZ5 jz5 = new JZ5();
        jz5.push(1);
        jz5.push(2);
        jz5.push(3);
        System.out.println(jz5.pop());
        System.out.println(jz5.pop());
        jz5.push(4);
        System.out.println(jz5.pop());
        System.out.println(jz5.pop());
    }
}
