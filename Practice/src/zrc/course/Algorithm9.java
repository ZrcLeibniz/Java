package zrc.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Algorithm9 {
}

// 使用堆加速后的迪杰斯塔拉算法（系统提供的堆，无法动态的调整的堆的结构，所以需要我们手动实现一个堆结构）
class Dijkstra2 {
    // 从head出发，所有head能到达的结点，生成到达每个结点的最小路径记录并返回
    public HashMap<Node, Integer> dijkstraII(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while (!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for (Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
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
    private HashMap<Node, Integer> heapIndexMap;
    private HashMap<Node, Integer> distanceMap;
    private int size;

    public NodeHeap(int size) {
        nodes = new Node[size];
        heapIndexMap = new HashMap<>();
        distanceMap = new HashMap<>();
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addOrUpdateOrIgnore(Node node, int distance) {
        if (inHeap(node)) {
            distanceMap.put(node, Math.min(distanceMap.get(node), distance));
            insertHeapify(node, heapIndexMap.get(node));
        }
        if (!isEntered(node)) {
            nodes[size] = node;
            heapIndexMap.put(node, size);
            distanceMap.put(node, distance);
            insertHeapify(node, size++);
        }
    }

    public NodeRecord pop() {
        NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
        swap(0, size - 1);
        heapIndexMap.put(nodes[size - 1], -1);
        distanceMap.remove(nodes[size - 1]);
        nodes[size - 1] = null;
        heapfiy(0, --size);
        return nodeRecord;
    }

    private boolean isEntered(Node node) {
        return heapIndexMap.containsKey(node);
    }

    private boolean inHeap(Node node) {
        return isEntered(node) && heapIndexMap.get(node) != -1;
    }

    public void swap(int index1, int index2) {
        heapIndexMap.put(nodes[index1], index2);
        heapIndexMap.put(nodes[index2], index1);
        Node temp = nodes[index1];
        nodes[index1] = nodes[index2];
        nodes[index2] = temp;
    }

    private void insertHeapify(Node node, int index) {
        while (distanceMap.get(nodes[index]) < distanceMap.get(nodes[(index - 1) / 2])) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapfiy(int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int smallest = left + 1 < size && distanceMap.get(nodes[left + 1]) < distanceMap.get(nodes[left]) ? left + 1 : left;
            smallest = distanceMap.get(nodes[smallest]) < distanceMap.get(nodes[index]) ? smallest : index;
            if (smallest == index) {
                break;
            }
            swap(smallest, index);
            index = smallest;
            left = index * 2 + 1;
        }
    }
}

class GraphD {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;
}

class NodeD {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;

    public NodeD(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

class EdgeD {
    public Node fromNode;
    public Node toNode;
    public int weight;

    public EdgeD(Node fromNode, Node toNode, int weight) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.weight = weight;
    }
}