package zrc.test.tree;

import zrc.tree.BlackRedTree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        BlackRedTree<Integer, String> blackRedTree = new BlackRedTree<>();
        blackRedTree.put(1, "张三");
        blackRedTree.put(2, "张四");
        blackRedTree.put(3, "张五");
        blackRedTree.put(4, "张六");
        blackRedTree.put(5, "张七");
        System.out.println(blackRedTree.get(1));
        System.out.println(blackRedTree.get(2));
        System.out.println(blackRedTree.get(3));
        System.out.println(blackRedTree.get(4));
        System.out.println(blackRedTree.get(5));
    }
}
