package zrc.course.algorithm7.practice1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public HashMap<Node, Integer> dijkstra(Graph graph, Node head) {
        HashMap<Node, Integer> result = new HashMap<>();
        HashSet<Node> set = new HashSet<>();
        result.put(head, 0);
        Node minNode = getMinDistanceAndUnSelectedNode(result, set);
        while (minNode != null) {
            Integer distance = result.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!set.contains(toNode)) {
                    result.put(toNode, distance + edge.weight);
                } else {
                    result.put(toNode, Math.min(result.get(toNode), distance + edge.weight));
                }
            }
            set.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(result, set);
        }
        return result;
    }

    public Node getMinDistanceAndUnSelectedNode(HashMap<Node, Integer> map, HashSet<Node> set) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : map.entrySet()) {
            Node node = nodeIntegerEntry.getKey();
            int distance = nodeIntegerEntry.getValue();
            if (!set.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
