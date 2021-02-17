package zrc.course;

import java.util.*;
import java.util.Map.Entry;

public class Algorithm7 {
}

// 如何描述图这种数据结构
class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }

    // 例如给定一个二维数组来表示图，第一列数据代表头，第二列代表结尾，第三列代表权重，写一个接口来转换成熟悉的图结构表示
    public Graph createGraph(int[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }

    // 图的宽度优先遍历
    public void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }

    // 图的深度优先遍历
    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }

    // 得到一个图的拓扑排序
    // 首先找到这种图中入度为0的节点，输出这个节点，之后在这张图中擦出这个节点对于这张图的影响，循环往复即可
    // 只要中这张图没有环，一定会结束
    public List<Node> sortedTopology(Graph graph) {
        // Key:代表图里的节点
        // Value:代表这个节点的入度
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            map.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                map.put(next, next.in - 1);
                if (map.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}

class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

// kruskal(可鲁斯卡尔)算法
// 无向图
// 求连通网最小生成树算法(原图的极小连通子图。即，包含原图中的所有n个结点，并且有保持图连通的最少的边)
// 从边的角度出发，将所有的边按照权值排序，之后将边加入到原来的节点，如果出现环不加，如果无环就加
class Kruskal {
    private class MySets {

        public HashMap<Node, List<Node>> setMap;

        public MySets(List<Node> nodes) {
            for (Node node : nodes) {
                List<Node> set = new ArrayList<>();
                set.add(node);
                setMap.put(node, set);
            }
        }

        public boolean isSameSet(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            return fromSet == toSet;
        }

        public void union(Node from, Node to) {
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for (Node toNode : toSet) {
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public Set<Edge> kruskalMST(Graph graph) {
        ArrayList<Node> nodes = new ArrayList<>(graph.nodes.values());
        MySets unionSet = new MySets(nodes);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        priorityQueue.addAll(graph.edges);
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionSet.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionSet.union(edge.from, edge.to);
            }
        }
        return result;
    }

    private class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}

// Prim(普里姆算法)算法
// 生成最小生成树
// 无向图
// 在算法的初始状态没有所有的边都处于封锁状态
// 随机选择一个节点开始，这个节点所拥有的所有边被解锁
// 选择一条权值最小的，之后将此条边能够到达的节点填充进set集合
// 之后将新节点所有边解锁，继续下去
// 如果解锁某条边后所获得的新节点，set集合中已经存在那么这条边不能选择
class Prim {
    public Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) { // 为了解决森林的问题，在最外层嵌套了一层for循环
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge poll = priorityQueue.poll();
                    Node toNode = poll.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(poll);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }

    private class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}

// Dijkstra算法
// 最短路径算法(给定出发点，得到的结果是：对于每一个结点到达该结点的最短路径是多少)
// 不能有累加和为负数的环
class Dijkstra {
    public HashMap<Node, Integer> dijkstra(Node head) {
        // 从head出发到所有点的最小距离
        // key:从head出发到达key
        // value:从head出发到达key的最小距离
        // 如果在表中，没有T的记录，含义是从head出发到T这个点的距离是正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经求过距离的节点，存放在selectNodes中，之后不能再次使用
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                } else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> touchedNods) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNods.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }
}