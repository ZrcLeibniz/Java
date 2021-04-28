package zrc.everyday;

import java.util.HashSet;

public class Question_20210428_2 {
    public static int solution(int n, int[] left, int[] right) {
        HashSet<Integer> table = new HashSet<>();
        // 第一步: 需要找到左边和右边同时存在的颜色
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] != 0 && right[i] != 0) {
                table.add(i);
            }
        }
        // 第二步: 做出决策
        // 决策一: 左边包含table中的一个颜色，右边包含table中的所有颜色
        // 决策二: 左边包含table中的所有颜色，右边包含table中的一个颜色
        int choiceI = num(n, left, right, table);
        int choiceII = num(n, right, left, table);
        return Math.min(choiceI, choiceII);
    }

    private static int num(int n, int[] left, int[] right, HashSet<Integer> table) {
        int choice = 0;
        // 计算左边需要多少手套
        for (int i = 0; i < n; i++) {
            if (!table.contains(i)) {
                choice += left[i];
            }
        }
        // 计算右边需要多少手套
        int min = Integer.MAX_VALUE;
        for (Integer integer : table) {
            if (min == Integer.MAX_VALUE) {
                min = integer;
            } else if (right[integer] < right[min]) {
                min = integer;
            }
        }
        for (int i = 0; i < right.length; i++) {
            if (i != min) {
                choice += right[i];
            }
        }
        choice += 2;
        return choice;
    }

    public static void main(String[] args) {
        int[] left = {0, 7, 1, 6};
        int[] right = {1, 5, 0, 6};
        int solution = solution(4, left, right);
        System.out.println(solution);
    }
}
