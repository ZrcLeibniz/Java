package zrc.course;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Course7 {
    public static void main(String[] args) {
        Cow cow = new Cow();
        int i = cow.numberOfCow(4);
        System.out.println(i);
        SumAim sumAim = new SumAim();
        boolean solution = sumAim.solution(new int[]{3, 0}, 2, 0, 0);
        System.out.println(solution);
    }
}

// 给定一个字符串数组，将此数组中的字符串全都拼接起来，要求得到的拼接后的字符串字典序最小
class LowestLexicography {
    private class MyComparator implements Comparator<String> {

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
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}

/*
一块金条分成两半，是需要花费和长度数值一样的铜板的。
例：长度为20的金条不管切成长度多大的两半都需要花费20个铜板
一群人想要瓜分金条，怎么分最省铜板
例：给定数组{10，20，30}，代表一共三个人，整块金条长度为10+20+30=60.金条要分成10，20，30三个部分。
如果，先把长度60的金条分成10和50需要花费60个铜板，再把长度50的金条分为20和30需要50个铜板，一共花费110个铜板
如果，先把长度60的金条分成30和30花费60个铜板，再把长度30的金条分为10和20，一共花费90铜板
 */
class LessMoney {

    public int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}

/*
给定一个数组cost和一个数组profit代表某一项目需要消耗的资金和收获的纯利润，给定次数K和初始资金W，求在做完K此项目后所获得的最大收益
 */
class IPO {
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
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
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

/*
一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
给定每一个项目开始的时间和结束的时间，要求会议室进行的宣讲场次最多。
返回宣讲场次
 */
class BestArrange {
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

    public int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new ProgramComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start) {
                result++;
                cur = programs[i].end;
            }
        }
        return result;
    }
}

/*
汉诺塔问题
 */
class Hanoi {
    public void hanoiTower(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move 1 from" + from + "to" + to);
        } else {
            hanoiTower(n - 1, from, to, help);
            System.out.println("Move" + n + "from" + from + "to" + to);
            hanoiTower(n - 1, help, to, from);
        }
    }
}

/*
打印一个字符串的全部子序列，包括空字符串
 */
class SonString {
    public void printAllSubString(char[] str, int i, String result) {
        if (i == str.length) {
            System.out.println(result);
            return;
        }
        printAllSubString(str, i + 1, result);
        printAllSubString(str, i + 1, result + String.valueOf(str[i]));
    }
}

// 母牛每年生一只母牛，新出生的母牛成长3年后也能生出一只母牛，假设不会死。求N年后，母牛的数量
class Cow {
    public int numberOfCow(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        if (N == 3) {
            return 3;
        }
        return numberOfCow(N - 1) + numberOfCow(N - 3);
    }
}

/*
给定一个二维数组，二维数组中的每个数都是正数，要求从左上角走到右下角，每一步只能向右或者向下。沿途经过的数字要累加起来。
返回最小路径和
 */
class minSumPath {
    public int minPath(int[][] matrix) {
        return process(matrix, matrix.length - 1, matrix[0].length - 1);
    }

    public int process(int[][] matrix, int i, int j) {
        int res = matrix[i][j];
        if (i == 0 && j == 0) {
            return res;
        }
        if (i == 0 && j != 0) {
            return res + process(matrix, i, j - 1);
        }
        if (i != 0 && j == 0) {
            return res + process(matrix, i - 1, j);
        }
        return res + Math.min(process(matrix, i, j - 1), process(matrix, i - 1, j));
    }
}

// 给定一个数组arr和一个整数aim
// 如果可以任意选择arr中的数字，若能累加到aim则返回true否则返回false
class SumAim {
    public boolean solution(int[] arr, int aim, int sum, int index) {
        if (index == arr.length) {
            return sum == aim;
        }
        return solution(arr, aim, sum, index + 1) || solution(arr, aim, sum + arr[index], index + 1);
    }
}