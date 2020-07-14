package zrc.tree.practice;

import zrc.linear.Queue;

public class BinaryTree01<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;
    private int N;

    private class Node<Key, Value> {
        public Key key;
        public Value value;
        public Node<Key, Value> left;
        public Node<Key, Value> right;

        public Node(Key key, Value value, Node<Key, Value> left, Node<Key, Value> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node<Key, Value> x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node<Key, Value>(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;
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
        } else if (cmp > 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        delete(root, key);
    }

    private Node delete(Node<Key, Value> x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;
        }
        return x;
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node<Key, Value> x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x.key;
        }
    }

    public Key max() {
        return max(root);
    }

    private Key max(Node<Key, Value> x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x.key;
        }
    }

    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    public void preErgodic(Node<Key, Value> x, Queue<Key> keys) {
        if (x == null) {
            return;
        }
        keys.enqueue(x.key);
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    public void midErgodic(Node<Key, Value> x, Queue keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            midErgodic(x.left, keys);
        }
        keys.enqueue(x.key);
        if (x.right != null) {
            midErgodic(x.right, keys);
        }
    }

    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    public void afterErgodic(Node<Key, Value> x, Queue keys) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }
        keys.enqueue(x.key);
    }

    public Queue<Key> layerErgodic() {
        Queue<Key> keys = new Queue<>();
        Queue<Node<Key, Value>> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            Node<Key, Value> dequeue = nodes.dequeue();
            keys.enqueue(dequeue.key);
            if (dequeue.left != null) {
                nodes.enqueue(dequeue.left);
            }
            if (dequeue.right != null) {
                nodes.enqueue(dequeue.right);
            }
        }
        return keys;
    }

    public int maxDepth() {
        return 0;
    }

    public int maxDepth(Node<Key, Value> x) {
        if (x == null) {
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        if (x.left != null) {
            maxL = maxDepth(x.left);
        }
        if (x.right != null) {
            maxR = maxDepth(x.right);
        }
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }
}
