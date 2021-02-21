package zrc.course.algorithm7.practice1;

import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch {
    public void solution(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (!set.contains(cur)) {
                for (Node next : cur.nexts) {
                    stack.add(cur);
                    stack.add(next);
                    System.out.println(next.value);
                    set.add(node);
                    break;
                }
            }
        }
    }
}
