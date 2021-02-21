package zrc.course.algorithm7.practice1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    public Set<Edge> solution(Graph graph) {
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
                Edge edge = priorityQueue.poll();
                Node toNode = edge.to;
                if (!set.contains(toNode)) {
                    set.add(toNode);
                    priorityQueue.addAll(toNode.edges);
                    result.add(edge);
                }
            }
        }
        return result;
    }
}
