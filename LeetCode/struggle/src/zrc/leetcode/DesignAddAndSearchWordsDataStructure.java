package zrc.leetcode;

//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 回溯算法 
// 👍 234 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    private class wordNode {
        public wordNode[] next;
        int end;

        public wordNode() {
            this.next = new wordNode[26];
            this.end = 0;
        }
    }

    private wordNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new wordNode();
    }

    public void addWord(String word) {
        if (word == null) {
            return;
        }
        char[] string = word.toCharArray();
        int index = 0;
        wordNode node = root;
        for (char c : string) {
            index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new wordNode();
            }
            node = node.next[index];
        }
        node.end++;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, wordNode root) {
        wordNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char charCur = word.charAt(i);
            if (charCur != '.' && node.next[charCur - 'a'] == null) {
                return false;
            }
            if (charCur == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null) {
                        if (search(word.substring(i + 1), node.next[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            node = node.next[charCur - 'a'];
        }
        return node.end != 0;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
