package zrc.course;

import java.util.HashMap;

public class Algorithm26 {
}

/*
在数据加密和数据压缩中常需要对特殊的字符串进行编码
给定的字母表由26小写英文字母组成，即A={a,b,...z}
该字母表产生的长序字符串是指定字符串中字符从左到右出现的次序与字母在字母表中出现的次序相同，且每个字符最多出现一次
例如：
    a、b、c 、d、...、ab、ac、...az、bc...
 */
class StringCoding {
    // 以第i个字符开头，总长度为len的字符串共有多少个
    public int g(int i, int len) {
        if (len == 1) {
            return 1;
        }
        int sum = 0;
        for (int j = i + 1; j <= 26; j++) {
            sum += g(j, len - 1);
        }
        return sum;
    }

    // 长度为len的字符串有多少个
    public int f(int len) {
        int sum = 0;
        for (int i = 1; i <= 26; i++) {
            sum += g(i, len);
        }
        return sum;
    }

    public int kTh(String s) {
        char[] str = s.toCharArray();
        int sum = 0;
        int len = str.length;
        for (int i = 1; i < len; i++) {
            sum += f(i);
        }
        int first = str[0] - 'a' + 1;
        for (int i = 1; i < first; i++) {
            sum += g(i, len);
        }
        int pre = first;
        for (int i = 1; i < len; i++) {
            int cur = str[i] - 'a' + 1;
            for (int j = pre + 1; j < cur; j++) {
                sum += g(j, len - i);
            }
            pre = cur;
        }
        return sum + 1;
    }
}

/*
给定一个数组，求如果排序之后，相邻两数的最大差值。要求时间复杂度为O(N)，且要求不能使用非基于比较的排序
 */
class MaxSubIfSort {
    public int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxS = new int[len + 1];
        int[] minS = new int[len + 1];
        int bid = 0;
        for (int num : nums) {
            bid = bucket(num, len, min, max);
            minS[bid] = hasNum[bid] ? Math.min(minS[bid], num) : num;
            maxS[bid] = hasNum[bid] ? Math.max(maxS[bid], num) : num;
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxS[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, minS[i] - lastMax);
                lastMax = maxS[i];
            }
        }
        return res;
    }

    private int bucket(int num, int len, int min, int max) {
        return (int) ((num - min) * len / (max - min));
    }
}

/*
给出n个数字a_1、a_2、...、a_n，问最多有多少不重叠的非空区间，使得每个区间的xor都等于0
 */
class MaxNumOfSpaceAndXORZero {
    public int solution(int[] arr) {
        int xor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor, i);
        }
        return dp[dp.length - 1];
    }
}

/*
现有n1+n2种面值的硬币，其中n1种为普通币，可以任意取
n2种为纪念币，每种最多只能取一枚
每种硬币都有一个面值，求有多少种方法拼出m的面值
 */
class OrdinaryCoinAndCommemorativeCoin {
    private int ordinaryCoin(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    private int process(int[] arr, int aim, int index) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int count = 0;
        for (int num = 0; num * arr[index] <= aim; num++) {
            count += process(arr, aim - num * arr[index], index + 1);
        }
        return count;
    }

    private int[] ordinaryCoinPart(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return new int[]{0};
        }
        int dp[][] = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int num = 0; num * arr[index] <= aim; num++) {
                    ways += dp[index + 1][aim - num * arr[index]];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0];
    }

    private int commemorativeCoin(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    private int processII(int[] arr, int aim, int index) {
        if (index == arr.length) {
            return aim == 0 ? 1 : 0;
        }
        int choiceI = processII(arr, aim, index + 1);
        int choiceII = processII(arr, aim - arr[index], index + 1);
        return choiceI + choiceII;
    }

    private int[] commemorativeCoinPart(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return new int[]{0};
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int index = dp.length - 2; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int choiceI = dp[index + 1][rest];
                int choiceII = aim - arr[index] < 0 ? 0 : dp[index + 1][aim - arr[index]];
                dp[index][rest] = choiceI + choiceII;
            }
        }
        return dp[0];
    }

    public int solution(int[] ordinaryCoin, int[] commemorativeCoin, int aim) {
        int[] commemorativeCoinPart = commemorativeCoinPart(commemorativeCoin, aim);
        int[] ordinaryCoinPart = ordinaryCoinPart(ordinaryCoin, aim);
        int length = ordinaryCoin.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += commemorativeCoinPart[i] * ordinaryCoinPart[length - i];
        }
        return result;
    }
}

/*
给定两个一维数组A和B
其中：A是长度为m，元素从小到大排好序的有序数组
      B是长度为n，元素从小到大排好序的有序数组
希望从数组A和数组B中，找出最小的K个数字
 */
class TwoArrayTopK {

}