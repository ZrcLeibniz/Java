package zrc.course.algorithm7.practice1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void solution(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (!set.contains(cur)) {
                set.add(cur);
                queue.addAll(cur.nexts);
            }
        }
    }
}
