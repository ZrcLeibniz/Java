package zrc.test.heap;

import zrc.heap.MaxPriorityQueue;
import zrc.heap.MinPriorityQueue;

public class MinPriorityQueueTest {
    public static void main(String[] args) {
        MinPriorityQueue<String> priorityQueue = new MinPriorityQueue<>(5);
        priorityQueue.insert("C");
        priorityQueue.insert("A");
        priorityQueue.insert("D");
        priorityQueue.insert("B");
        priorityQueue.insert("E");
        System.out.println(priorityQueue.delMin());
    }
}
