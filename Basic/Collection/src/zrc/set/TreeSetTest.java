package zrc.set;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("Z");
        treeSet.add("X");
        treeSet.add("Y");
        treeSet.add("B");
        treeSet.add("Z");
        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
