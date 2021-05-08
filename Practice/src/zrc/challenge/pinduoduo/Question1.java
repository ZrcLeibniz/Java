package zrc.challenge.pinduoduo;
/*
多多君最近在研究某种数字组合：
定义为：每个数字的十进制表示中(0~9)，每个数位各不相同且各个数位之和等于N。
满足条件的数字可能很多，找到其中的最小值即可。
多多君还有很多研究课题，于是多多君找到了你--未来的计算机科学家寻求帮助。

输入描述:共一行，一个正整数N，如题意所示，表示组合中数字不同数位之和。（1 <= N <= 1,000）

输出描述:共一行，一个整数，表示该组合中的最小值。如果组合中没有任何符合条件的数字，那么输出-1即可。
 */

import java.util.*;

public class Question1 {
    public static int solution(int num) {
        if (num < 10) {
            return num;
        }
        if (num > 45) {
            return -1;
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        process(result, path, 0, 9, num);
        StringBuilder solution = new StringBuilder();
        for (int i = result.get(0).size() - 1; i >= 0; i--) {
            solution.append(result.get(0).get(i));
        }
        return Integer.parseInt(solution.toString());
    }

    private static void process(List<List<Integer>> result, Deque<Integer> path, int sum, int index, int num) {
        if (sum == num) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i > 0; i--) {
            int cur = sum + i;
            if (cur > num) {
                continue;
            }
            path.addLast(i);
            process(result, path, sum + i, index - 1, num);
            path.removeLast();
            break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int solution = solution(num);
            System.out.println(solution);
        }
    }
}
