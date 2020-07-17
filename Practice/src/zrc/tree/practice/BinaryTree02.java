package zrc.tree.practice;


import zrc.linear.Queue;

public class BinaryTree02<Key extends Comparable<Key>, Value> {
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

    private Node<Key, Value> put(Node<Key, Value> x, Key key, Value value) {
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

    public Value get(Node<Key, Value> x, Key key) {
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

    public void delete(Key key) {
        delete(root, key);
    }

    public Node delete(Node<Key, Value> x, Key key) {
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

    public int size() {
        return N;
    }

    public Key min() {
        return min(root);
    }

    public Key min(Node<Key, Value> x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x.key;
        }
    }

    public Key Max() {
        return max(root);
    }

    public Key max(Node<Key, Value> x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x.key;
        }
    }

    public Queue<Key> preErgodic() {
        Queue<Key> queue = new Queue<>();
        preErgodic(root, queue);
        return queue;
    }

    private void preErgodic(Node<Key, Value> x, Queue<Key> queue) {
        if (x == null) {
            return;
        }
        queue.enqueue(x.key);
        if (x.left != null) {
            preErgodic(x.left, queue);
        }
        if (x.right != null) {
            preErgodic(x.right, queue);
        }
    }

    public Queue<Key> midErgodic() {
        Queue<Key> queue = new Queue<>();
        midErgodic(root, queue);
        return queue;
    }

    private void midErgodic(Node<Key, Value> x, Queue queue) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            midErgodic(x.left, queue);
        }
        queue.enqueue(x.key);
        if (x.right != null) {
            midErgodic(x.right, queue);
        }
    }

    public Queue<Key> afterErgodic() {
        Queue<Key> queue = new Queue<>();
        afterErgodic(root, queue);
        return queue;
    }

    private void afterErgodic(Node<Key, Value> x, Queue queue) {
        if (x == null) {
            return;
        }
        if (x.left != null) {
            afterErgodic(x.left, queue);
        }
        if (x.right != null) {
            afterErgodic(x.right, queue);
        }
        queue.enqueue(x.key);
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
        return maxDepth(root);
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
