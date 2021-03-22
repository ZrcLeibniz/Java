package zrc.course;

import java.util.*;

public class Algorithm25 {
}

/*
给定一个整数数组，长度为n，有1<=A[i]<=n，且对于[1,n]的整数，其中部分整数会重复出现，而部分不会出现
请找到全部未出现的整数
 */
class NumNoInArray {
    public List<Integer> solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        for (int value : arr) {
            modify(value, arr);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public void modify(int value, int[] arr) {
        while (arr[value - 1] != value) {
            int temp = arr[value - 1];
            arr[value - 1] = value;
            value = temp;
        }
    }
}

/*
在一个平台给主播刷礼物，目前主播的人气值是a, 目标是让主播的人气值达到b，有三种方式
    1.点赞，花费X 人气值+2
    2.送礼物，花费Y，人气值*2
    3.私聊，花费Z，人气值-2
求最少的花费
a和b都是偶数
 */
class MinCostMoney {
    public int solution(int add, int times, int del, int start, int end) {
        if (start > end) {
            return -1;
        }
        return process(0, end, add, times, del, start, end * 2, ((end - start) / 2) * add);
    }

    private int process(int preMoney, int aim, int add, int times, int del, int cur, int limitAim, int limitCoin) {
        if (preMoney > limitCoin) {
            return Integer.MAX_VALUE;
        }
        if (cur < 0) {
            return Integer.MAX_VALUE;
        }
        if (cur > limitAim) {
            return Integer.MAX_VALUE;
        }
        if (aim == cur) {
            return preMoney;
        }
        int min = Integer.MAX_VALUE;
        int p1 = process(preMoney + add, aim, add, times, del, cur + 2, limitAim, limitCoin);
        if (p1 != Integer.MAX_VALUE) {
            min = p1;
        }
        int p2 = process(preMoney + times, aim, add, times, del, cur * 2, limitAim, limitCoin);
        if (p2 != Integer.MAX_VALUE) {
            min = Math.min(min, p2);
        }
        int p3 = process(preMoney + del, aim, add, times, del, cur - 2, limitAim, limitCoin);
        if (p3 != Integer.MAX_VALUE) {
            min = Math.min(min, p3);
        }
        return min;
    }
}

/*
CC直播的运营部门组织了很多运营活动，每个活动需要花费一定的时间参与，主播每参与完一个活动即可得到一定的奖励
参与活动可以从任何一个活动开始，但是一旦开始，就需要将后续活动参加完毕（最后一个活动必须参加）活动之间存在一定的依赖关系
先给出所有活动时间与依赖关系，以及给出有限时间
请计算在有限时间内，能获得的最大奖励以及需要的最少时间
 */
class MaxRevenue {
    public int[] maxRevenue(int allTime, int[] revenue, int[] times, int[][] dependents) {
        int size = revenue.length;
        HashMap<Integer, ArrayList<Integer>> parents = new HashMap<>();
        for (int i = 0; i < size; i++) {
            parents.put(i, new ArrayList<>());
        }
        int end = -1;
        for (int i = 0; i < dependents.length; i++) {
            boolean allZero = true;
            for (int j = 0; j < dependents[0].length; j++) {
                if (dependents[i][j] != 0) {
                    parents.get(j).add(i);
                    allZero = false;
                }
                if (allZero) {
                    end = i;
                }
            }
        }
        HashMap<Integer, TreeMap<Integer, Integer>> nodeCostRevenueMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            nodeCostRevenueMap.put(i, new TreeMap<>());
        }
        nodeCostRevenueMap.get(end).put(times[end], revenue[end]);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(end);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int last : parents.get(cur)) {
                for (Map.Entry<Integer, Integer> entry : nodeCostRevenueMap.get(cur).entrySet()) {
                    int lastCost = entry.getKey() + times[last];
                    int lastRevenue = entry.getValue() + revenue[last];
                    TreeMap<Integer, Integer> lastMap = nodeCostRevenueMap.get(last);
                    if (lastMap.floorKey(lastCost) == null || lastMap.get(lastMap.floorKey(lastCost)) < lastRevenue) {
                        lastMap.put(lastCost, lastRevenue);
                    }
                }
                queue.add(last);
            }
        }
        TreeMap<Integer, Integer> allMap = new TreeMap<>();
        for (TreeMap<Integer, Integer> curMap : nodeCostRevenueMap.values()) {
            for (Map.Entry<Integer, Integer> entry : curMap.entrySet()) {
                int cost = entry.getKey();
                int rev = entry.getValue();
                if (allMap.floorKey(cost) == null || allMap.get(allMap.floorKey(cost)) < rev) {
                    allMap.put(cost, rev);
                }
            }
        }
        return new int[] {allMap.floorKey(allTime), allMap.get(allMap.floorKey(allTime))};
    }
}

/*
给定一个只由0(假)、1(真)、&(逻辑与)、|(逻辑或)和^(异或)五种字符组成的字符串express
再给定一个布尔值desired。
 */
class ExpressionNumber {
    public int solution(String express, boolean desired) {
        if (express == null || express.equals("")) {
            return 0;
        }
        char[] exp = express.toCharArray();
        if (!isValid(exp)) {
            return 0;
        }
        return process(exp, desired, 0, exp.length - 1);
    }

    private boolean isValid(char[] exp) {
        if ((exp.length & 1) == 0) {
            return false;
        }
        for (int i = 0; i < exp.length; i += 2) {
            if ((exp[i] != '1') && (exp[i] != '0')) {
                return false;
            }
        }
        for (int i = 1; i < exp.length; i += 2) {
            if ((exp[i] != '&') && (exp[i] != '|') && (exp[i] != '^')) {
                return false;
            }
        }
        return true;
    }

    private int process(char[] exp, boolean desired, int L, int R) {
        if (L == R) {
            if (exp[L] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = L + 1; i < R; i += 2) {
                switch (exp[i]) {
                    case '&':
                        res += process(exp, true, L, i - 1) * process(exp, true, i + 1, R);
                        break;
                    case '|':
                        res += process(exp, true, L, i - 1) * process(exp, true, i + 1, R);
                        res += process(exp, true, L, i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, false, L, i - 1) * process(exp, true, i + 1, R);
                        break;
                    case '^':
                        res += process(exp, true, L, i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, false, L, i - 1) * process(exp, true, i + 1, R);
                        break;
                }
            }
        } else {
            for (int i = L + 1; i < R; i++) {
                switch (exp[i]) {
                    case '&':
                        res += process(exp, false, L, i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, true, L, i - 1) * process(exp, false, i + 1, R);
                        res += process(exp, false, L, i - 1) * process(exp, true, i + 1, R);
                        break;
                    case '|':
                        res += process(exp, false, L, i - 1) * process(exp, false, i + 1, R);
                        break;
                    case '^':
                        res += process(exp, true, L, i - 1) * process(exp, true, i + 1, R);
                        res += process(exp, false, L, i - 1) * process(exp, false, i + 1, R);
                        break;
                }
            }
        }
        return res;
    }

    public int dpLive(String express, boolean desired) {
        char[] str = express.toCharArray();
        int N = str.length;
        int[][] tMap = new int[N][N];
        int[][] fMap = new int[N][N];
        for (int i = 0; i < N; i += 2) {
            tMap[i][i] = str[i] == 1 ? 1 : 0;
            fMap[i][i] = str[i] == 0 ? 0 : 1;
        }
        for (int row = N - 3; row >= 0; row -= 2) {
            for (int col = row + 2; col < N; col += 2) {
                for (int i = row + 1; i < col; i += 2) {
                    switch (str[i]) {
                        case '&':
                            tMap[row][col] = tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                        case '|':
                            tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            tMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                        case '^':
                            tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            break;
                    }
                    switch (str[i]) {
                        case '&':
                            fMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
                            fMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                        case '|':
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            break;
                        case '^':
                            fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
                            fMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
                            break;
                    }
                }
            }
        }
        return desired ? tMap[0][N - 1] : fMap[0][N - 1];
    }
}

/*
在一个字符串中找到一个没有重复字串中最长的长度
 */
class MaxUnique {
    public int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i != chars.length; i++) {
            pre = Math.max(map[chars[i]], pre);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chars[i]] = i;
        }
        return len;
    }
}

/*
给定两个字符串str1和str2，再给定三个整数ic、dc和rc分别代表插入，删除和替换一个字符串的代价，返回将str1编辑为str2的最小编辑距离
 */
class minEditCost {
    public int solution(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null) {
            return 0;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 2;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + rc;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + ic);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dc);
            }
        }
        return dp[row - 1][col - 1];
    }
}

/*
给定一个全是小写字母的字符串str，删除多余字符，使得每种字符只保留一个，并让最终结果字符串的字典序最小
 */
class remove {
    public String remove(String str) {
        if (str == null || str.length() < 2) {
            return str;
        }
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int minASCIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (--map[str.charAt(i)] == 0) {
                break;
            } else {
                minASCIndex = str.charAt(minASCIndex) > str.charAt(i) ? i : minASCIndex;
            }
        }
        return String.valueOf(str.charAt(minASCIndex)) + remove(str.substring(minASCIndex + 1).replaceAll(String.valueOf(str.charAt(minASCIndex)), ""));
    }
}