package zrc.course;

import java.util.LinkedList;
import java.util.Stack;

public class Algorithm12 {
}

// Manacher算法
/*
字符串str中，最长回文字串的长度应该如何求解，要求时间复杂度为O(N)
对于经典解法，我们可以遍历每一个字符串，然后针对每一个字符串向两边扩充，不断更新最大长度即可
但是这样会导致偶数长度的回文串被错误的解答，所以我们可以在每个字符串的开头结尾和字符中间加入
辅助字符，将最终得到的结果除以2即可
也可以使用动态规划的解法
对于“马拉车”算法，首先明确几个概念
回文半径/直径：我们需要一个数组来将每一个位置的回文半径记录下来
    例如："#a#1#2#1#b#"，以2为出发点
    回文直径为7 回文半径为4
之前所扩张过的所有字符中所能到达最右的位置(最右回文右边界)
取得最远边界的中心点
1.当来到一个点时，这个点没有在最右回文右边界中
    暴力扩张即可
2.当来到一个点时，这个点在最右回文右边界中
    我们以此时的最右回文有边界的中心点为轴，做出此时i点的对称点j
    即：
        .....(L.....j....C....i.....R)..............
    我们通过j点的回文情况分为以下几种小情况
    (1)j点的回文区域在L和R内部
        得出i点的回文半径和j点一致
    (2)j点的回文区域有某一部分已经超出L和R的范围
        得出i点的回文半径就是R-i+1
    (3)j点的回文区域正好与L重合
        得到i点最短的回文半径是R-i+1，但是是否可以变得更远，需要进一步尝试
        我们直接从开始校验i-(R-i+1)位置和R+1即可
 */
class Manacher {
    // 动态规划解法
    public String solutionI(String string) {
        int begin = 0;
        int max = 0;
        char[] chars = string.toCharArray();
        boolean[][] dp = new boolean[string.length()][string.length()];
        for (int i = 0; i < string.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < string.length(); j++) {
            for (int i = 0; i < string.length(); i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && j - i + 1 > max) {
                        begin = i;
                        max = j - i + 1;
                    }
                }
            }
        }
        return string.substring(begin, begin + max);
    }

    private char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public int manacher(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int C = -1;
        int R = -1; // 回文右边界的再往右一个位置
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1; // 处理穿的回文半径-1就是原始串的回文半径
    }
}

// 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑倒最右边，窗口每次向右边滑一个位置
// 例如，数组为[4,3,5,4,3,3,6,7],窗口大小为3时
// [4,3,5],4,3,3,6,7    max=5
// 4,[3,5,4],3,3,6,7    max=5
// 4,3,[5,4,3],3,6,7    max=5
// 4,3,5,[4,3,3],6,7    max=4
// 4,3,5,4,[3,3,6],7    max=6
// 4,3,5,4,3,[3,6,7]    max=7
// 请实现一个函数
// 输入：整型数组：arr，窗口大小：w
// 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
class SlideWindow {
    private int L;
    private int R;
    private int[] arr;
    private LinkedList<Integer> max;

    public SlideWindow(int[] a) {
        arr = a;
        L = -1;
        R = 0;
        max = new LinkedList<>();
    }

    public void addNumberFromRight() {
        if (R == arr.length) {
            return;
        }
        while (!max.isEmpty() && arr[max.peekLast()] <= arr[R]) {
            max.pollLast();
        }
        max.addLast(R);
        R++;
    }

    public void removeNumFromLeft() {
        if (L >= R - 1) {
            return;
        }
        L++;
        if (max.peekLast() == L) {
            max.pollFirst();
        }
    }

    public int[] getWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> max = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!max.isEmpty() && arr[max.peekLast()] <= arr[i]) {
                max.peekLast();
            }
            max.addLast(i);
            if (max.peekFirst() == i - w) {
                max.removeFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[max.peekFirst()];
            }
        }
        return res;
    }
}

// 单调栈
/*
对于一个数组，要获得每一个元素左边比本身大的最近元素和右边比本身大的最近元素
 */
class MonotoneStack {
    public Integer[][] solution(int[] arr) {
        Integer[][] result = new Integer[arr.length][2];
        MonotoneStack stack = new MonotoneStack(arr);
        for (int i = 0; i < arr.length; i++) {
            while (arr[stack.peek()] < arr[i]) {
                Integer pop = stack.pop();
                result[pop][0] = stack.isEmpty() ? null : arr[stack.peek()];
                result[pop][1] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            result[pop][0] = stack.isEmpty() ? null : stack.peek();
            result[pop][1] = null;
        }
        return result;
    }

    private Stack<LinkedList<Integer>> stack;
    int[] arr;

    public MonotoneStack(int[] arr) {
        this.stack = new Stack<>();
        this.arr = arr;
    }

    public Integer peek() {
        return stack.peek().get(0);
    }

    public void push(int val) {
        if (val < stack.peek().get(0)) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(val);
            stack.push(list);
        } else if (val == stack.peek().get(0)) {
            stack.peek().addLast(val);
        }
    }

    public Integer pop() {
        if (stack.peek().size() == 1) {
            return stack.pop().get(0);
        } else {
            stack.peek().removeLast();
            return stack.peek().get(0);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

// 定义: 数组中累积和与最小值的乘积，作为这个数组的指标
// 给定一个数组，请返回子数组中，最大的指标值
/*
我们可以如此定义流程：
    遍历数组的每一个元素，得到以当前元素为最小值，可以扩充的最大范围，也就是累加和最大的情况
    这样就可以得到当前元素的指标
 */
class Quota {
    public int solution(int[] arr) {
        Integer[][] limit = limit(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int left = limit[i][0] == null ? 0 : limit[i][0];
            int right = limit[i][1] == null ? arr.length - 1 : limit[i][1];
            int sum = 0;
            for (int j = left; j < right; j++) {
                sum += arr[i];
            }
            int result = sum * arr[i];
            max = Math.max(result, max);
        }
        return max;
    }

    public Integer[][] limit(int[] arr) {
        Integer[][] limit = new Integer[arr.length][2];
        LimitStack stack = new LimitStack(arr);
        for (int i = 0; i < arr.length; i++) {
            while (arr[stack.peek()] < arr[i]) {
                Integer pop = stack.pop();
                limit[pop][0] = stack.isEmpty() ? null : stack.peek();
                limit[pop][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            limit[pop][0] = stack.isEmpty() ? null : stack.peek();
            limit[pop][1] = null;
        }
        return limit;
    }

    private class LimitStack {
        private Stack<LinkedList<Integer>> stack;
        int[] arr;

        public LimitStack(int[] arr) {
            this.stack = new Stack<>();
            this.arr = arr;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public void push(int val) {
            if (arr[stack.peek().get(0)] > val) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(val);
                stack.add(list);
            } else if (arr[stack.peek().get(0)] == val){
                stack.peek().add(val);
            }
        }

        public int pop() {
            if (stack.peek().size() == 1) {
                return stack.pop().get(0);
            } else {
                stack.peek().removeLast();
                return stack.peek().get(0);
            }
        }

        public int peek() {
            return stack.peek().get(0);
        }
    }
}