package zrc.course;

public class Algorithm8_1 {

}

/*
例子：
    前提.一个字符串类型的数组arr1，另一个字符串类型的数组arr2
    1.arr2中有哪些字符是arr1中出现的
    2.arr2中有哪些字符，是作为arr1中某个字符串前缀出现的
    3.arr2中有哪些字符，是作为arr1中某个字符串前缀出现的
    4.请打印arr2中出现次数最多的前缀
 */

class TrieTreeI {
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

    public TrieTreeI() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) {
            return;
        }
        char[] values = word.toCharArray();
        TrieNode node = root;
        root.pass++;
        int index = 0;
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
        if (word == null) {
            return 0;
        }
        TrieNode node = root;
        char[] values = word.toCharArray();
        int index = 0;
        for (char value : values) {
            index = value - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    // 所有加入过的字符串中，有几个是以pre这样的字符串作为前缀的
    public int prefixNumber(String pre) {
        if (pre == null) {
            return 0;
        }
        TrieNode node = root;
        int index = 0;
        char[] values = pre.toCharArray();
        for (char value : values) {
            index = value - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] values = word.toCharArray();
            TrieNode node = root;
            node.pass--;
            int index = 0;
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