package zrc.test.heap;

import zrc.heap.IndexMinPriorityQueue;

public class IndexMinPriorityQueueTest {
    public static void main(String[] args) {
        IndexMinPriorityQueue<String> indexMinPriorityQueue = new IndexMinPriorityQueue<>(10);
        indexMinPriorityQueue.insert(0, "A");
        indexMinPriorityQueue.insert(1, "C");
        indexMinPriorityQueue.insert(2, "F");
        indexMinPriorityQueue.insert(3, "B");
        indexMinPriorityQueue.insert(4, "E");
        indexMinPriorityQueue.insert(5, "D");
        indexMinPriorityQueue.changeItem(2, "B");
        while (!indexMinPriorityQueue.isEmpty()) {
            System.out.println(indexMinPriorityQueue.delMin());
        }
    }
}
