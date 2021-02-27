package zrc.course.algorithm9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DijkstraII {
    public HashMap<Node, Integer> solution(Node head, int size) {
        NodeHeap heap = new NodeHeap(size);
        heap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!heap.isEmpty()) {
            NodeRecord pop = heap.pop();
            Node cur = pop.node;
            int distance = pop.distance;
            for (Edge edge : cur.edges) {
                heap.addOrUpdateOrIgnore(edge.to, edge.weight + pop.distance);
            }
            result.put(cur, distance);
        }
        return result;
    }
}

class Graph {
    HashMap<Integer, Node> nodes;
    HashSet<Edge> edges;
}

class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
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

class NodeRecord {
    public Node node;
    public int distance;

    public NodeRecord(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class NodeHeap {
    private Node[] nodes;
    private HashMap<Node, Integer> indexNodeMap;
    private HashMap<Node, Integer> distanceMap;
    int size;

    public NodeHeap(int size) {
        nodes = new Node[size];
        indexNodeMap = new HashMap<>();
        distanceMap = new HashMap<>();
        this.size = 0;
    }

    public void addOrUpdateOrIgnore(Node node, int distance) {
        if (isEntered(node)) {
            distanceMap.put(node, Math.min(distanceMap.get(node), distance));
            insertHeapfiy(indexNodeMap.get(node));
        }
        if (!inHeap(node)) {
            nodes[size] = node;
            distanceMap.put(node, distance);
            indexNodeMap.put(node, size);
            insertHeapfiy(size++);
        }
    }

    public NodeRecord pop() {
        NodeRecord result = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
        swap(0, size - 1);
        indexNodeMap.put(nodes[size - 1], -1);
        distanceMap.remove(nodes[size - 1]);
        nodes[size - 1] = null;
        heapify(0, --size);
        return result;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isEntered(Node node) {
        return indexNodeMap.containsKey(node);
    }

    private boolean inHeap(Node node) {
        return isEntered(node) && indexNodeMap.get(node) != -1;
    }

    private void swap(int index1, int index2) {
        indexNodeMap.put(nodes[index1], index2);
        indexNodeMap.put(nodes[index2], index1);
        Node temp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
    }

    private void heapify(int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int smallest = left + 1 < size && distanceMap.get(nodes[left]) > distanceMap.get(nodes[left + 1]) ? left + 1 : left;
            smallest = distanceMap.get(nodes[index]) < distanceMap.get(nodes[smallest]) ? index : smallest;
            if (smallest == index) {
                break;
            }
            swap(smallest, index);
            index = smallest;
            left = index * 2 + 1;
        }
    }

    private void insertHeapfiy(int index) {
        while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}