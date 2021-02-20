package zrc.course.algorithm8;

public class TrieTree {
    private class TrieNode {
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new TrieNode[26];
        }
    }

    private TrieNode root;

    public TrieTree() {
        this.root = new TrieNode();
    }

    // 如何根据一个字符串数组生成前缀树
    public void insert(String word) {
        char[] values = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char value : values) {
            index = value - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    // 查找一个字符串添加过几次
    public int search(String word) {
        char[] values = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char value : values) {
            index = value - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    // 所有加入过的字符串中，有几个是以pre作为前缀的
    public int prefixNumber(String pre) {
        char[] values = pre.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char value : values) {
            index = value - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    // 在前缀树中删除一个字符串
    public void delete(String word) {
        if (search(word) > 0) {
            char[] values = word.toCharArray();
            int index = 0;
            TrieNode node = root;
            for (char value : values) {
                index = value - 'a';
                if (--node.nexts[index].pass == 0) {
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }
}
