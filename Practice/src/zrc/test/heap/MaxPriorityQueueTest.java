package zrc.test.heap;

import zrc.heap.MaxPriorityQueue;

public class MaxPriorityQueueTest {
    public static void main(String[] args) {
        MaxPriorityQueue<String> priorityQueue = new MaxPriorityQueue<>(5);
        priorityQueue.insert("C");
        priorityQueue.insert("A");
        priorityQueue.insert("D");
        priorityQueue.insert("B");
        priorityQueue.insert("E");
        System.out.println(priorityQueue.delMax());
    }
}
