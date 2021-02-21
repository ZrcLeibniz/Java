package zrc.course.algorithm7.practice1;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int[] graphNode : matrix) {
            int from = graphNode[0];
            int to = graphNode[1];
            int weight = graphNode[2];
            if (!nodes.containsKey(from)) {
                nodes.put(from, new Node(from));
            }
            if (!nodes.containsKey(to)) {
                nodes.put(to, new Node(to));
            }
            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);
            Edge edge = new Edge(fromNode, toNode, weight);
            fromNode.nexts.add(toNode);
            graph.edges.add(edge);
            fromNode.out++;
            toNode.in++;
        }
        return graph;
    }
}
