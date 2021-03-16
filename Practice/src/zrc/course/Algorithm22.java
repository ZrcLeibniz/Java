package zrc.course;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Algorithm22 {
}

/*
如何使用O(logN)的时间复杂度求解斐波那契数列
 */
class FabLogN {
    public int solution(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {
                {1, 1},
                {1, 0}
        };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    private int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = mulMatrix(res, t);
            }
            t = mulMatrix(t, t);
        }
        return res;
    }

    private int[][] mulMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}

// 母牛每年生一只母牛，新出生的母牛成长3年后也能生出一只母牛，假设不会死。求N年后，母牛的数量
class CowNumber {
    public int solution(int N) {
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
        return solution(N - 1) + solution(N - 3);
    }
}

// 母牛每年生两只母牛，新出生的母牛成长2年后也能生出2只母牛，假设5年会死。求N年后，母牛的数量
class CowNumberII {
    public int solution(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 3;
        }
        if (N == 3) {
            return 5;
        }
        if (N == 4) {
            return 10;
        }
        return solution(N - 1) + 2 * solution(N - 2) - solution(N - 5);
    }
}

/*
字符串只由0和1两种字符构成
当字符串长度为1时，所有可能的字符串是0和1
当字符串长度为2时，所有可能的字符串00 01 10 11
当字符串长度为3时，所有可能的字符串为000 001 010 011 100 101 110 111...
如果某一个字符串中，只要是出现0的位置，左边就靠着1，这样的字符串叫做达标字符串
给定一个正数N，返回所有长度为N的字符串中，达标字符串的数量
 */
class ValidString {
    public int solution(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        return solution(N - 1) + solution(N - 2);
    }
}

/*
有n根木棍，第i根木棍的长度为i，现在如何去掉一些木棍，使得任意三根木棍都不能组成三角形
求，最少去掉多少根
 */
class TriangleWoodStick {
    public int solution(int N) {
        return 0;
    }
}

/*
共有n袋零食，第i袋零食的体积为V[i]
在不超过背包体积的情况下，一共有多少种零食方法
 */
class BagII {
    // 体积刚好为V的时候有多少种方法
    public int solution(int[] array, int v) {
        return process(array, 0, v);
    }

    private int process(int[] array, int index, int v) {
        if (index == array.length) {
            return v == 0 ? 1 : 0;
        }
        int result = 0;
        result += process(array, index + 1, v);
        result += process(array, index + 1, v - array[index]);
        return result;
    }

    // 正解
    public int solutionII(int[] array, int V) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[][] dp = new int[array.length + 1][V + 1];
        dp[dp.length - 1][0] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] += dp[i + 1][j];
                dp[i][j] += j - array[i] < 0 ? 0 : dp[i + 1][j - array[i]];
            }
        }
        int result = 0;
        for (int i = 0; i < dp[0].length; i++) {
            result += dp[dp.length - 1][i];
        }
        return result;
    }
}

/*
给定一个job类型的数组表示工作
给定一个int类型的数组表示能力
返回int类型的数组，表示每一个人按照难度不超过能力值的前提下，获取的最高薪资
 */
class JobAndSalary {
    private static class Job {
        public int money;
        public int hard;
    }

    public int[] solution(int[] ability, Job[] job) {
        Arrays.sort(job, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(pre.hard, pre.money);
            }
        }
        int[] result = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            result[i] = key != null ? map.get(key) : 0;
        }
        return result;
    }
}

// 判断一个字符串是否符合日常的书写习惯,如果符合，转为数字输出，如果不是或者越界，返回最大值或最小值
class isValidNum {
    public boolean isValid(char[] str) {
        if (str[0] != '-' && (str[0] < '0' || str[0] > '9')) {
            return false;
        }
        if (str[0] == '-' && (str.length == 1 || str[1] == '0')) {
            return false;
        }
        if (str[0] == '0' && str.length > 1) {
            return false;
        }
        for (int i = 1;  i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public int convert(String s) {
        if (s== null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        if (isValid(str)) {
            throw new RuntimeException("can not convert");
        }
        boolean neg = str[0] == '-';
        int minQ = Integer.MIN_VALUE / 10;
        int minR = Integer.MIN_VALUE % 10;
        int result = 0;
        int cur = 0;
        for (int i = neg ? 1 : 0; i < str.length; i++) {
            cur = '0' - str[i];
            if ((result < minQ) || (result == minQ && cur <minR)) {
                throw new RuntimeException("can not convert");
            }
            result = result * 10 + cur;
        }
        if (!neg && result == Integer.MIN_VALUE) {
            throw new RuntimeException("can not convert");
        }
        return neg ? result : -result;
    }
}