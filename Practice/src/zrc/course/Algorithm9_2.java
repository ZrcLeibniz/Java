package zrc.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Algorithm9_2 {

}

// 汉诺塔问题
class HanoiTower {
    public void hanoiTower(int n) {
        if (n > 0) {
            process(n, "左", "中", "右");
        }
    }

    public void process(int i, String start, String end, String other) {
        if (i == 1) {
            System.out.println("Move 1 from " + start + " to " + end);
        }
        process(i - 1, start, other, end);
        System.out.println("Move " + i + " from " + start + " to " + end);
        process(i - 1, other, end, start);
    }
}

// 找到一个字符串的全部子序列
class AllSubString {
    public void solution(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0, new ArrayList<Character>());
    }

    private void process(char[] str, int i, List<Character> res) {
        if (i == str.length) {
            printList(res);
            return;
        }
        List<Character> resKeep = copyList(res);
        resKeep.add(str[i]);
        process(str, i + 1, resKeep);
        List<Character> resNoInclude = copyList(res);
        process(str, i + 1, resNoInclude);
    }

    private List<Character> copyList(List<Character> res) {
        List<Character> result = new ArrayList<>(res);
        return result;
    }

    private void printList(List<Character> res) {
        for (Character re : res) {
            System.out.print(re);
        }
    }

    public void solutionII(String str) {
        char[] chs = str.toCharArray();
        processII(chs, 0);
    }

    private void processII(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        processII(chs, i + 1);
        char temp = chs[i];
        chs[i] = 0;
        processII(chs, i + 1);
        chs[i] = temp;
    }
}

// 打印一个字符串的全部排列
// 进阶：要求不要出现重复的排列
class AllStringArray {
    public ArrayList<String> solution(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, result);
        return result;
    }

    private void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(String.valueOf(chs));
        }
        //boolean[] visit = new boolean[26];
        for (int j = i; j < chs.length; j++) {
            //if (!visit[chs[j] - 'a']) {
            //visit[chs[j] - 'a'] = true;
            swap(chs, i, j);
            process(chs, i + 1, res);
            swap(chs, i, j);
            //}
        }
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}

// 给定一个整型数组arr，代表数值不同的纸牌拍成一条线
// 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿
// 每个玩家只能拿走最左或最右的纸牌
// 请返回最后获胜者的分数
// 玩家们都异常聪明
class WinPoint {
    public int winI(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    public int f(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    public int s(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }
}

// 逆序一个栈,不能使用额外空间
class reverseStack {
    public void solution(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = process(stack);
        solution(stack);
        stack.push(i);
    }

    private int process(Stack<Integer> stack) {
        int pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int last = process(stack);
            stack.push(pop);
            return last;
        }
    }
}

// 规定1对应A、2对应B...
// 给定一个由数字组成字符串，返回有多少种转化的结果
class NumberToString {
    public int solution(String str) {
        char[] chars = str.toCharArray();
        return process(chars, 0);
    }

    private int process(char[] string, int i) {
        if (i == string.length) {
            return 1;
        }
        if (string[i] == '0') {
            return 0;
        }
        if (string[i] == '1') {
            int res = process(string, i + 1);
            if (i + 1 < string.length) {
                res += process(string, i + 2);
            }
            return res;
        }
        if (string[i] == '2') {
            int res = process(string, i + 1);
            if (i + 1 < string.length && (string[i + 1] >= '0' && string[i + 1] <= '6')) {
                res += process(string, i + 2);
            }
            return res;
        }
        return process(string, i + 1);
    }
}

// 给定两个长度都为N的数组weights和values
// 给定一个整数bag表示一个载重bag的袋子，你装的物品不能超过这个重量
// 返回你能装下最多的价值是多少
class BagQuestion {
    public int solution(int[] weight, int[] values, int i, int alreadyWeight, int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weight.length) {
            return 0;
        }
        return Math.max(values[i] + solution(weight, values, i + 1, alreadyWeight + weight[i], bag),
                solution(weight, values, i + 1, alreadyWeight, bag));
    }
}

// N皇后问题
// 在N*N棋盘上要摆N个皇后，要求任何两个皇后不同列、不同行、也不在同一条斜线上
// 给定一个整数n，返回n皇后的摆法有多少种
class Queen {
    public int solution(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return process(0, record, n);
    }

    public int process(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    private boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public int solutionII(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int upperLim = n == 32 ? -1 : (1 << n) - 1;
        return processII(upperLim, 0, 0, 0);
    }

    private int processII(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos = 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += processII(upperLim, colLim | mostRightOne,
                    (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}