package zrc.course.algorithm8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CostProfitMax {
    private class Project {
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    private class MinCostComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.cost - o2.cost;
        }
    }

    private class MaxProfitComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit - o1.profit;
        }
    }

    public int solution(int[] cost, int[] profit, int k, int w) {
        Project[] projects = new Project[cost.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(cost[i], profit[i]);
        }
        PriorityQueue<Project> minCostQueue = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Project> maxProfitQueue = new PriorityQueue<>(new MaxProfitComparator());
        minCostQueue.addAll(Arrays.asList(projects));
        for (int i = 0; i < k; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= w) {
                maxProfitQueue.add(minCostQueue.poll());
            }
            if (maxProfitQueue.isEmpty()) {
                return w;
            }
            w = maxProfitQueue.poll().profit + w;
        }
        return w;
    }
}
