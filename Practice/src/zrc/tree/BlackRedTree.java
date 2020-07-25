package zrc.tree;

public class BlackRedTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node<Key, Value> {
        public Node<Key, Value> left;
        public Node<Key, Value> right;
        public Key key;
        public Value value;
        public boolean color;

        public Node(Node left, Node right, Key key, Value value, boolean color) {
            this.left = left;
            this.right = right;
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private boolean isRed(Node<Key, Value> x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node<Key, Value> h) {
        Node<Key, Value> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node<Key, Value> h) {
        Node<Key, Value> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        x.color = RED;
        return x;
    }

    private void flipColors(Node<Key, Value> h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node<Key, Value> h, Key key, Value value) {
        if (h == null) {
            N++;
            return new Node<Key, Value>(null, null, key, value, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node<Key, Value> x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    public int size() {
        return N;
    }
}
