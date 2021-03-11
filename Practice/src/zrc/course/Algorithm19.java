package zrc.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Algorithm19 {
}

/*
给定一个非负数，代表二叉树的节点个数。返回能形成多少种不同的二叉树结构
 */
class NodeTree {
    public int solution(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int leftNum = 0; leftNum <= n - 1; leftNum++) {
            int leftWays = solution(leftNum);
            int rightWays = solution(n - 1 - leftNum);
            res += leftWays * rightWays;
        }
        return res;
    }

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = dp[j - 1] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

/*
一个完整的括号字符串的定义规则如下：
    1.空字符串是完整的
    2.如果s是完整字符串那么(s)也是完整的
    3.如果s和t是完整的字符串，将其连接起来形成的st也是完整的
先有一个括号字符串s，现在需要在其中任意位置尽量少的添加括号，将其转换为一个完整的括号字符串
求:至少需要添加多少个括号
 */
class ValidBrackets {
    public int solution(String str) {
        int p = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                p++;
            } else {
                if (p == 0) {
                    result++;
                } else {
                    p--;
                }
            }
        }
        return p + result;
    }
}

/*
给定一个数组arr，求差值为k的去重数字对
 */
class KSubNum {
    public List<List<Integer>> allPair(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) {
            set.add(value);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer cur : set) {
            if (set.contains(cur + k)) {
                result.add(Arrays.asList(cur, cur + k));
            }
        }
        return result;
    }
}

/*
给定一个包含n个整数元素的集合a，一个包含m个整数元素的集合b
定义magic操作为：从一个集合中抽取一个元素放到另外一个集合中，且操作过后每个集合的平均值都大于之前
1)不可以把一个集合的元素去空，这样就没有平均值了
2)值为x的元素从集合b取出放入集合a，但是集合a中已经有值为x的元则a的平均值不变，b的平均值可能会被改变
求最多可以进行多少次magic操作
 */
class MagicAction {
    public int solution(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int item : arr1) {
            sum1 += (double) item;
        }
        double sum2 = 0;
        for (int value : arr2) {
            sum2 += (double) value;
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int value : arrMore) {
            if ((double) value < avg(sumMore, moreSize) && (double) value > avg(sumLess, lessSize) && !setLess.contains(value)) {
                sumMore -= (double) value;
                moreSize--;
                sumLess += (double) value;
                lessSize++;
                setLess.add(value);
                ops++;
            }
        }
        return ops;
    }

    private double avg(double sum, int length) {
        return sum / (double) (length);
    }
}

/*
一个合法的括号匹配序列有以下定义
    1.空字符串是完整的
    2.如果s是完整字符串那么(s)也是完整的
    3.如果s和t是完整的字符串，将其连接起来形成的st也是完整的
对于一个合法的括号序列我们由有定义它的深度
    1.空串的深度是0
    2.如果字符串X的深度是x，字符串y的深度是y，那么字符串XY的深度是max(x, y)
    3.如果X的深度是x， 那么字符串X的深度所示x+1
 */
class DepthBrackets {
    public int solution(String str) {
        char[] string = str.toCharArray();
        if (!isValid(string)) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (char c : string) {
            if (c == '(') {
                max = Math.max(max, ++count);
            } else {
                count--;
            }
        }
        return max;
    }

    private boolean isValid(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        int status = 0;
        for (char c : str) {
            if (c != ')' && c != '(') {
                return false;
            }
            if ((c == ')' && --status < 0)) {
                return false;
            }
            if (c == '(') {
                status++;
            }
        }
        return status == 0;
    }

    // 求最长的有效括号长度
    public int maxLength(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/*
给定一个字符串
    1---a
    2---b
      .
      .
      .
    26--z
编写一个函数求可以转换的不同字符串的个数
例如:12258可以转换的个数是5
 */
class IntegerToString {
    public int solution(String s) {
        return process(s.toCharArray(), 0);
    }

    private int process(char[] string, int index) {
        if (index == string.length) {
            return 1;
        }
        if (string[index] == 0) {
            return 0;
        }
        if (string[index] == '1') {
            int result = process(string, index + 1);
            if (index + 1 < string.length) {
                result += process(string, index + 2);
            }
        }
        if (string[index] == '2') {
            int result = process(string, index + 1);
            if (index + 1 < string.length && string[index + 1] <= '6' && string[index + 1] >= '1') {
                result += process(string, index + 2);
            }
        }
        return process(string, index + 1);
    }
}

/*
二叉树每个结点都有一个int型的权值，给定一颗二叉树，要求计算从根节点到叶节点的所有路径中，权值和最大的值为多少
 */
class weightTreeNode {
    private static class TreeNode {
        int weight;
        TreeNode left;
        TreeNode right;

        public TreeNode(int weight) {
            this.weight = weight;
        }
    }

    public static int solution(TreeNode root) {
        return process(root);
    }

    public static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = process(root.left);
        int rightSum = process(root.right);
        return Math.max(leftSum, rightSum) + root.weight;
    }
}

/*
给定一个元素为非负整数的二维数组matrix，每行和没列都是从小到大有序的
给定一个非负整数aim，请判断aim是否在matrix中
 */
class MatrixAim {
    public boolean solution(int[][] matrix, int aim) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > aim) {
                col--;
            } else if (matrix[row][col] < aim) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}