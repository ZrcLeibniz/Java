package zrc.test.tree;

import zrc.linear.Queue;

public class PaperFolding {
    public static void main(String[] args) {
        Node<String> tree = createTree(3);
        printTree(tree);
    }

    public static Node<String> createTree(int N) {
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                root = new Node<String>("down", null, null);
            } else {
                Queue<Node> queue = new Queue<>();
                queue.enqueue(root);
                while (!queue.isEmpty()) {
                    Node<String> temp = queue.dequeue();
                    if (temp.left != null) {
                        queue.enqueue(temp.left);
                    }
                    if (temp.right != null) {
                        queue.enqueue(temp.right);
                    }
                    if (temp.left == null && temp.right == null) {
                        temp.left = new Node<String>("down", null, null);
                        temp.right = new Node<String>("up", null, null);
                    }
                }
            }
        }
        return root;
    }

    public static void printTree(Node<String> root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            printTree(root.left);
        }
        System.out.print(root.item + " ");
        if (root.right != null) {
            printTree(root.right);
        }
    }

    private static class Node<T> {
        public T item;
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
