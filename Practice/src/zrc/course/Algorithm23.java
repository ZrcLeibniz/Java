package zrc.course;

import java.util.TreeMap;

public class Algorithm23 {
}

/*
给定一个字符串类型的数组arr，例如
    {"b\\cst","d\\","a\\d\\e","a\\b\\c"}
将这些路径中蕴含的目录结构打印出来，子目录在父目录下面，并比父目录向右前进两格
 */
class PrintCatalog {
    private class Node {
        public String name;
        TreeMap<String, Node> nextMap;

        Node(String name) {
            this.name = name;
            this.nextMap = new TreeMap<>();
        }
    }

    public void solution(String[] folderPaths) {
        if (folderPaths == null || folderPaths.length == 0) {
            return;
        }
        Node head = generateFolderTree(folderPaths);
        printProcess(head, 0);
    }

    private void printProcess(Node node, int level) {
        if (level != 0) {
            System.out.println(get2nSpace(level) + node.name);
        }
        for (Node next : node.nextMap.values()) {
            printProcess(next, level + 1);
        }
    }

    private String get2nSpace(int level) {
        String res = "";
        for (int i = 1; i < level; i++) {
            res += " ";
        }
        return res;
    }

    private Node generateFolderTree(String[] folderPaths) {
        Node head = new Node("");
        for (String foldPath : folderPaths) {
            String[] path = foldPath.split("\\\\");
            Node cur = head;
            for (String s : path) {
                if (!cur.nextMap.containsKey(s)) {
                    cur.nextMap.put(s, new Node(s));
                }
                cur = cur.nextMap.get(s);
            }
        }
        return head;
    }
}

/*
双向链表结点结构和二叉树结点结构是一样的，如果认为last是left，next是right
给定一个搜索二叉树的头节点head，请转化为一条有序的双向链表
 */
class BinarySearchTreeConvertLinkedList {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private class Info {
        public TreeNode start;
        public TreeNode end;

        public Info(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(null, null);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        if (leftInfo.end != null) {
            leftInfo.end.right = root;
        }
        root.left = leftInfo.end;
        root.right = rightInfo.start;
        if (rightInfo.start != null) {
            rightInfo.start.left = root;
        }
        return new Info(leftInfo.start == null ? root : leftInfo.start, rightInfo.end == null ? root : rightInfo.end);
    }

    public TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        return process(root).start;
    }
}

/*
找到一颗二叉树中，最大的搜索二叉子树，返回最大搜索二叉子树的根节点
 */
class MaxSubBinarySearchTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private static class Info {
        TreeNode maxBSTHead;
        boolean isBST;
        int min;
        int max;
        int maxBSTSize;

        public Info(TreeNode maxBSTHead, boolean isBST, int min, int max, int maxBSTSize) {
            this.maxBSTHead = maxBSTHead;
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.maxBSTSize = maxBSTSize;
        }
    }

    public static Info process(TreeNode root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int min = root.val;
        int max = root.val;
        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
        }
        int maxBSTSize = 0;
        TreeNode maxBSTHead = null;
        boolean isBST = false;
        if (leftInfo != null) {
            maxBSTSize = leftInfo.maxBSTSize;
            maxBSTHead = leftInfo.maxBSTHead;
        }
        if (rightInfo != null && rightInfo.maxBSTSize > maxBSTSize) {
            maxBSTHead = rightInfo.maxBSTHead;
            maxBSTSize = rightInfo.maxBSTSize;
        }
        if ((leftInfo == null || leftInfo.isBST) && (rightInfo == null || rightInfo.isBST)) {
            if ((leftInfo == null || leftInfo.max < root.val) && (rightInfo == null || rightInfo.min > root.val)) {
                isBST = true;
                maxBSTHead = root;
                int leftSize = leftInfo == null ? 0 : leftInfo.maxBSTSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.maxBSTSize;
                maxBSTSize = leftSize + rightSize + 1;
            }
        }
        return new Info(maxBSTHead, isBST, min, max, maxBSTSize);
    }

    public TreeNode solution(TreeNode root) {
        if (root == null) {
            return null;
        }
        return process(root).maxBSTHead;
    }
}

/*
给定一个数组，请找到这样一个子数组，其累加和是最大的
 */
class MaxSubArraySum {
    public int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i != arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = Math.max(cur, 0);
        }
        return max;
    }
}

/*
给定一个整型矩阵，返回子矩阵的最大累计和
 */
class MaxSubMatrixSum {
    public int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null;
        for (int i = 0; i != matrix.length; i++) {
            s = new int[matrix[0].length];
            for (int j = i; j != matrix.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += matrix[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = Math.max(cur, 0);
                }
            }
        }
        return max;
    }
}