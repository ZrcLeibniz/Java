package zrc.test.linear;

import zrc.linear.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        stringStack.push("d");
        for (String s: stringStack) {
            System.out.println(s);
        }

        System.out.println();
        stringStack.pop();
        for (String s: stringStack) {
            System.out.println(s);
        }

        System.out.println();
        stringStack.pop();
        for (String s: stringStack) {
            System.out.println(s);
        }

        System.out.println();
        stringStack.pop();
        for (String s: stringStack) {
            System.out.println(s);
        }
    }
}
