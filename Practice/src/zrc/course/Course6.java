package zrc.course;


import java.util.HashMap;
import java.util.List;

public class Course6 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        CountOfIsland countOfIsland = new CountOfIsland();
        int solution = countOfIsland.solution(arr);
        System.out.println(solution);
    }
}

// 并查集
class UnionFindSet {
    private class Node {
        // Whatever you like
    }

    public HashMap<Node, Node> fatherMap;
    public HashMap<Node, Integer> sizeMap;

    public UnionFindSet(List<Node> nodes) {
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        makeSets(nodes);
    }

    private void makeSets(List<Node> nodes) {
        for (Node node : nodes) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    private Node findHead(Node node) {
        Node father = fatherMap.get(node);
        if (father != node) {
            father = findHead(father);
        }
        fatherMap.put(node, father);
        return father;
    }

    public boolean isSameSet(Node a, Node b) {
        return findHead(a) == findHead(b);
    }

    public void union(Node a, Node b) {
        if (a == null || b == null) {
            return;
        }
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        if (aHead != bHead) {
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            if (aSetSize <= bSetSize) {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSetSize + bSetSize);
            } else {
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSetSize + bSetSize);
            }
        }
    }
}

// 岛问题
/*
一个矩阵中只有0或1两种值，每个位置都可以和自己的上、下、左、右四个位置相连，如果有一片1连在一起这个部分叫一个岛
求一个矩阵非岛屿数
 */
class CountOfIsland {

    public int solution(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count = count + 1;
                    help(arr, i, j);
                }
            }
        }
        return count;
    }

    private void help(int[][] arr, int row, int col) {
        if (arr[row][col] == 0) {
            return;
        }
        arr[row][col] = 0;
        if (row + 1 < arr.length) {
            help(arr, row + 1, col);
        }
        if (row - 1 >= 0) {
            help(arr, row - 1, col);
        }
        if (col + 1 < arr[0].length) {
            help(arr, row, col + 1);
        }
        if (col - 1 >= 0) {
            help(arr, row, col - 1);
        }
    }
}

// 前缀树
class TrieTree {
    private class TrieNode {
        public int path;
        public int end;
        public TrieNode[] nexts;

        public TrieNode () {
            path = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].path == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    // 查询一个字符串在前缀树中添加过几次
    public int search(String word) {
        if (word == null) {
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    // 查询一个字符串作为前缀出现的次数
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.path;
    }
}

