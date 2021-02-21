package zrc.course.algorithm7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DijkstraII {
    public HashMap<Node, Integer> dijkstra(Graph graph, Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        HashSet<Node> selectedNodes = new HashSet<>();
        distanceMap.put(head, 0);
        Node minNode = getMinDistanceAndUnSelectedNode(selectedNodes, distanceMap);
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
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnSelectedNode(selectedNodes, distanceMap);
        }
        return distanceMap;
    }

    public Node getMinDistanceAndUnSelectedNode(HashSet<Node> set, HashMap<Node, Integer> map) {
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
