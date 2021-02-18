package zrc.course.algorithm7;

import java.util.*;

public class SortedTopology {
    // 按照拓扑排序
    // 对于一张图而言，我们先对图中的每个节点和其入度将其记录在哈希表中
    // 并且首先处理入度为0的节点，在将此节点处理之后，消除这个节点对于图的影响
    // 循环往复，只要图无环，一定能将整个图处理完毕
    public static List<Node> topology(Graph graph) {
        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Integer> map = new HashMap<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                map.put(next, map.get(next) - 1);
                if (next.in == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
