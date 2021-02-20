package zrc.course;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Algorithm8_2 {
}

// 贪心算法
/*
    在某一个标准下，优先考虑最满足标准的样本，最后考虑最不满足标准的样本
    最终得到答案的算法，叫做贪心算法
    也就是说，不从整体最优上加以考虑，所做出的是在某种意义上的局部最优解
 */

// 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目宣讲。给定一些项目的开始时间和结束时间
// 要求会议室进行宣讲的场次最多，返回这个最多的宣讲场次
class MostCountPublicLecture {
    private class Program {
        int start;
        int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    public int bestArrange(Program[] programs, int timePoint) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (Program program : programs) {
            if (program.start >= timePoint) {
                result++;
                timePoint = program.end;
            }
        }
        return result;
    }
}

// 给定以个字符串数组，要求将所有的字符串拼接起来，字典序最小
class MinDictionaryOrder {
    private static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }
        return result.toString();
    }
}

// 一句块金条切成两半，是需要花费和长度数值一样的铜板的。一群人想要分整块金条，返回分割最小的代价
class MinCost {
    public int solution(int[] golden) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int value : golden) {
            priorityQueue.add(value);
        }
        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(sum);
        }
        return sum;
    }
}

/*
给定一个数组cost和一个数组profit代表某一项目需要消耗的资金和收获的纯利润，给定次数K和初始资金W，求在做完K此项目后所获得的最大收益
 */
class CostProfitMax {
    private class Node {
        int p;
        int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    private class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    private class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] Profits, int[] Capital) {
        Node[] nodes = new Node[Profits.length];
        for (int i = 0; i < Profits.length; i++) {
            nodes[i] = new Node(Profits[i], Capital[i]);
        }
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        minCostQ.addAll(Arrays.asList(nodes));
        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }
}

