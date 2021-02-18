package zrc.course.algorithm7;

import java.util.*;

public class Prim {
    public static Set<Edge> prim (Graph graph) {
        HashSet<Edge> result = new HashSet<>();
        HashSet<Node> set = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for (Node node : graph.nodes.values()) {
            set.add(node);
            priorityQueue.addAll(node.edges);
            while (!priorityQueue.isEmpty()) {
                Edge poll = priorityQueue.poll();
                if (!set.contains(poll.to)) {
                    set.add(poll.to);
                    result.add(poll);
                    priorityQueue.addAll(poll.to.edges);
                }
            }
        }
        return result;
    }
}
