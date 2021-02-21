package zrc.course.algorithm7.practice1;

import java.util.*;

public class Kruskal {
    private class Union {
        HashMap<Node, List<Node>> setMap;

        public Union(List<Node> nodes) {
            for (Node node : nodes) {
                ArrayList<Node> list = new ArrayList<>();
                list.add(node);
                setMap.put(node, list);
            }
        }

        public boolean isSameUnion(Node node1, Node node2) {
            List<Node> nodes1 = setMap.get(node1);
            List<Node> nodes2 = setMap.get(node2);
            return node1 == node2;
        }

        public void union(Node node1, Node node2) {
            List<Node> nodes1 = setMap.get(node1);
            List<Node> nodes2 = setMap.get(node2);
            for (Node node : nodes1) {
                nodes2.add(node);
                setMap.put(node, nodes2);
            }
        }
    }

    public Set<Edge> solution(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        List<Node> nodes = new ArrayList<>(graph.nodes.values());
        Union union = new Union(nodes);
        HashSet<Edge> result = new HashSet<>();
        priorityQueue.addAll(graph.edges);
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            Node fromNode = edge.from;
            Node toNode = edge.to;
            if (!union.isSameUnion(fromNode, toNode)) {
                result.add(edge);
                union.union(fromNode, toNode);
            }
        }
        return result;
    }

    private static class EdgeComparator implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
