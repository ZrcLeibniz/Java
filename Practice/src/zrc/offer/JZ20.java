package zrc.offer;

import java.util.Stack;

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1)）。
 */
public class JZ20 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackHelp = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (stackHelp.isEmpty() || node <= stackHelp.peek()) {
            stackHelp.push(node);
        }
    }

    public void pop() {
        stack.pop();
        if (stackHelp.peek() == stack.peek()) {
            stackHelp.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackHelp.peek();
    }

    public static void main(String[] args) {
        JZ20 jz20 = new JZ20();
        jz20.push(3);
        System.out.println(jz20.min());
        jz20.push(4);
        System.out.println(jz20.min());
        jz20.push(2);
        System.out.println(jz20.min());
        jz20.push(3);
        System.out.println(jz20.min());
        jz20.pop();
        System.out.println(jz20.min());
        jz20.pop();
        System.out.println(jz20.min());
        jz20.pop();
        System.out.println(jz20.min());
        jz20.push(20);
        System.out.println(jz20.min());
    }
}
