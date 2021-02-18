package zrc.course.algorithm7;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;

    // 给定某一个图结构将其转换为我们熟悉的图
    // [[from],[to],[weight]]
    public Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][1];
            int weight = matrix[i][2];
            // 首先对整个图结构进行填充
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(fromNode, toNode, weight);
            graph.edges.add(edge);
            // 对图节点进行填充
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
        }
        return graph;
    }
}