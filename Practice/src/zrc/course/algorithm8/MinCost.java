package zrc.course.algorithm8;

import java.util.PriorityQueue;

public class MinCost {
    public int solution(int[] golden) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int value : golden) {
            priorityQueue.add(value);
        }
        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() != 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(sum);
        }
        return sum;
    }
}
