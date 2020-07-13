package zrc.test.tree;

import zrc.linear.Queue;
import zrc.tree.BinaryTree;

import java.util.Iterator;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> binaryTree = new BinaryTree<>();
        binaryTree.put(5, "张三");
        binaryTree.put(3, "李四");
        binaryTree.put(6, "王五");
        System.out.println(binaryTree.size());
        binaryTree.delete(6);
        System.out.println(binaryTree.size());
        System.out.println(binaryTree.get(5));
    }
}
