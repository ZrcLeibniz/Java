package zrc.course.algorithm7;

import java.util.*;

public class Kruskal {
    // 该算法主要用于图的最小生成树的算法
    // 该算法以图的边出发，选择权值最小的边，如果加入该边后，产生了环，那么放弃这条边否则加入
    // 对于是否产生环，我们可以使用并查集来解决这个问题，如果两个节点在一个集合中则产生环
    // 1.该边所依附的两个定顶点分属于不同的连同分量。这时可以选择一条边作为最小生成树边，因为两个不同连同分量
    // 通过这条便的链接而相互连通，成为了一个连同分量
    // 2.该边所依附的两个顶点属于同一个连通分量。如果选择这条边作为最小生成树的一条边，则必将构成环。因为你连通
    // 分量中任意两个顶点都有路径相通，一旦再加入一条边，该边所依附的两个顶点之间就有了两条路径，故应该舍弃
    private static class MySet {
        HashMap<Node, List<Node>> setMap;

        public MySet(List<Node> nodes) {
            for (Node node : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(node);
                setMap.put(node, set);
            }
        }

        public boolean isSameUnion(Node node1, Node node2) {
            List<Node> node1Set = setMap.get(node1);
            List<Node> node2Set = setMap.get(node2);
            return node1Set == node2Set;
        }

        public void union(Node node1, Node node2) {
            List<Node> nodes = setMap.get(node2);
            for (Node node : nodes) {
                setMap.get(node2).add(node);
                setMap.put(node, setMap.get(node2));
            }
        }
    }

    public static Set<Edge> kruskal(Graph graph) {
        List<Node> nodes = new ArrayList<>(graph.nodes.values());
        MySet mySet = new MySet(nodes);
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        queue.addAll(graph.edges);
        Set<Edge> result = new HashSet<>();
        for (Edge edge : queue) {
            Node fromNode = edge.from;
            Node toNode = edge.to;
            if (!mySet.isSameUnion(fromNode, toNode)) {
                mySet.union(fromNode, toNode);
                result.add(edge);
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
