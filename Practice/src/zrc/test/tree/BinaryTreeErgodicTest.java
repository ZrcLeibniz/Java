package zrc.test.tree;

import zrc.linear.Queue;
import zrc.tree.BinaryTree;

import java.util.Iterator;

public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, String> binaryTree = new BinaryTree<>();
        binaryTree.put("E", "5");
        binaryTree.put("B", "2");
        binaryTree.put("G", "7");
        binaryTree.put("A", "1");
        binaryTree.put("D", "4");
        binaryTree.put("F", "6");
        binaryTree.put("H", "8");
        binaryTree.put("C", "3");
        Queue<String> preQueue = binaryTree.preErgodic();
        Iterator<String> iterator1 = preQueue.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("-------------------------------------------------------------------");
        Queue<String> midQueue = binaryTree.midErgodic();
        Iterator<String> iterator2 = midQueue.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println("-------------------------------------------------------------------");
        Queue<String> afterQueue = binaryTree.afterErgodic();
        Iterator<String> iterator3 = afterQueue.iterator();
        while (iterator3.hasNext()) {
            System.out.println(iterator3.next());
        }
        System.out.println("-------------------------------------------------------------------");
        Queue<String> layerQueue = binaryTree.layerErgodic();
        Iterator<String> iterator4 = layerQueue.iterator();
        while (iterator4.hasNext()) {
            System.out.println(iterator4.next());
        }
        System.out.println(binaryTree.maxDepth());
    }
}
