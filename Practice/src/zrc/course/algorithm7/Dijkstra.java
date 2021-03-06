package zrc.course.algorithm7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public HashMap<Node, Integer> dijkstra(Graph graph, Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        HashSet<Node> selectNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnSelectedNode(selectNodes, distanceMap);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(toNode, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectNodes.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(selectNodes, distanceMap);
        }
        return distanceMap;
    }

    public Node getMinDistanceAndUnSelectedNode(HashSet<Node> selectNodes, HashMap<Node, Integer> distanceMap) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> nodeIntegerEntry : distanceMap.entrySet()) {
            Node node = nodeIntegerEntry.getKey();
            int distance = nodeIntegerEntry.getValue();
            if (!selectNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}
