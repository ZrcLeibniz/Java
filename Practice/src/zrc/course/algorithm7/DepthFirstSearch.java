package zrc.course.algorithm7;

import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch {
    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    System.out.println(next.value);
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }
    }
}
