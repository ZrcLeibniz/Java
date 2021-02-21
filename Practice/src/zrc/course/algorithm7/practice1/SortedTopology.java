package zrc.course.algorithm7.practice1;


import java.util.*;

public class SortedTopology {
    public List<Node> solution(Graph graph) {
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        List<Node> result = new ArrayList<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node);
            for (Node next : node.nexts) {
                map.put(next, next.in - 1);
                if (next.in == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
