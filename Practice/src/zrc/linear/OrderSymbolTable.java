package zrc.linear;

public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> head;
    private int N;

    private class Node<Key, Value> {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head = new Node<Key, Value>(null, null, null);
        this.N = 0;
    }

    public Value get(Key key) {
        Node<Key, Value> currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
            if (currNode.key.equals(key)) {
                return currNode.value;
            }

        }
        return null;
    }

    public void put(Key key, Value value) {
        Node<Key, Value> currNode = head.next;
        Node<Key, Value> preNode = head;
        while (currNode != null && key.compareTo(currNode.key) > 0) {
            preNode = currNode;
            currNode = currNode.next;
        }
        if (currNode != null && key.compareTo(currNode.key) == 0) {
            currNode.value = value;
            return;
        }
        Node<Key, Value> node = new Node<>(key, value, currNode);
        preNode.next = node;
        N++;
    }

    public void delete(Key key) {
        Node<Key, Value> node = head;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                node.next = node.next.next;
                N--;
                return;
            }
            node = node.next;
        }
    }

    public int size() {
        return N;
    }
}
