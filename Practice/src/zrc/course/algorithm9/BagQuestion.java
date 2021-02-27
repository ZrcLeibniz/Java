package zrc.course.algorithm9;

// 给定两个长度都为N的数组weights和values
// 给定一个整数bag表示一个载重bag的袋子，你装的物品不能超过这个重量
// 返回你能装下最多的价值是多少
public class BagQuestion {
    public int solution(int[] weights, int[] values, int bag) {
        return solution(weights, values, 0, 0, bag);
    }

    private int solution(int[] weights, int[] values, int i, int curWeight, int bag) {
        if (curWeight > bag) {
            return 0;
        }
        int valueSel = values[i] + solution(weights, values, i + 1, curWeight + weights[i], bag);
        int valueNo = solution(weights, values, i + 1, curWeight, bag);
        return Math.max(valueSel, valueNo);
    }
}
