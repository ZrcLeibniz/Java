package zrc.course;

import java.util.HashMap;

public class Algorithm24 {
}

/*
路灯问题
对于一条路来说，我们将其看为格子，假设将路灯设置在pos位置上，那么可以照亮的地方为pos-1和pos+1
需要照亮的地方用'.'表示，不需要照亮额地方用'X'表示
返回一个正数表示最少需要多少盏路灯
 */
class minLight {
    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int index = 0;
        int light = 0;
        while (index < str.length) {
            if (str[index] == 'X') {
                index++;
            } else {
                light++;
                if (index + 1 == str.length) {
                    break;
                } else {
                    if (str[index + 1] == 'X') {
                        index = index + 2;
                    } else {
                        index = index + 3;
                    }
                }
            }
        }
        return light;
    }
}

/*
已知一颗二叉树中没有重复节点，并且给定了这棵树的中序遍历和先序遍历
请返回后序遍历数组
 */
class PostTraversal {
    public int[] solution(int[] pre, int[] mid) {
        int[] pos = new int[pre.length];
        int length = pre.length - 1;
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            inMap.put(mid[i], i);
        }
        set(pre, mid, pos, 0, length, 0, length, 0, length, inMap);
        return pos;
    }

    private void set(int[] pre, int[] in, int[] pos, int preI, int preJ, int inI, int inJ, int posI, int posJ, HashMap<Integer, Integer> map) {
        if (preI > preJ) {
            return;
        }
        if (preI == preJ) {
            pos[posI] = pre[preI];
        }
        pos[posJ] = pre[preI];
        int find = map.get(pre[preI]);
        set(pre, in, pos, preI + 1, preI + find - inI, inI, find - 1, posI, posI + find - inI - 1, map);
        set(pre, in, pos, preI + find - inI + 1, preJ, find + 1, inJ, posI + find - inI, posJ - 1, map);
    }
}

/*
给定一个数字，请返回正确的英文格式
 */
class IntegerConvertEnglish {
    public String num1To19(int num) {
        if (num < 1 || num > 19) {
            return "";
        }
        String[] names = {
                "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine", "ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                "Nineteen"
        };
        return names[num - 1];
    }

    public String num1To99(int num) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 20) {
            return num1To19(num);
        }
        int high = num / 10;
        String[] tyNames = {
                "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };
        return tyNames[high - 2] + num1To19(num % 10);
    }

    public String num1To999(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return num1To99(num);
        }
        int high = num / 100;
        return num1To19(high) + "Hundred" + num1To99(num % 100);
    }

    public String getNumEngExp(int num) {
        if (num == 0) {
            return "Zero";
        }
        String res = "";
        if (num < 0) {
            res = "Negative, ";
        }
        if (num == Integer.MIN_VALUE) {
            res += "Tow Billion, ";
            num %= -2000000000;
        }
        num = Math.abs(num);
        int high = 1000000000;
        int highIndex = 0;
        String[] names = {"Billion", "Million", "Thousand"};
        while (num != 0) {
            int cur = num / high;
            num %= high;
            if (cur != 0) {
                res += num1To999(cur);
                res += names[highIndex] + (num == 0 ? " " : ",");
            }
            high /= 1000;
            highIndex++;
        }
        return res;
    }
}

/*
给定一串数字，请将其转换为汉字的表达形式
 */
class IntegerConvertChinese {
    public String num1To9(int num) {
        if (num < 1 || num > 9) {
            return "";
        }
        String[] names = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return names[num - 1];
    }

    public String num1To99(int num, boolean hasBai) {
        if (num < 1 || num > 99) {
            return "";
        }
        if (num < 10) {
            return num1To9(num);
        }
        int shi = num / 10;
        if (shi == 1 && (!hasBai)) {
            return "十" + num1To9(num % 10);
        } else {
            return num1To9(num / 10) + "十" + num1To9(num % 10);
        }
    }

    public String num1To999(int num) {
        if (num < 1 || num > 999) {
            return "";
        }
        if (num < 100) {
            return num1To99(num, false);
        }
        String res = num1To9(num / 100) + "百";
        int rest = num % 100;
        if (rest == 0) {
            return res;
        } else if (rest >= 10) {
            res += num1To99(rest, true);
        } else {
            res += "零" + num1To9(rest);
        }
        return res;
    }

    public String num1To9999(int num) {
        if (num < 1 || num > 9999) {
            return "";
        }
        if (num < 1000) {
            return num1To999(num);
        }
        String res = num1To9(num / 1000) + "千";
        int rest = num % 1000;
        if (rest == 0) {
            return res;
        } else if (rest >= 100) {
            res += num1To999(rest);
        } else {
            res += "零" + num1To9(rest);
        }
        return res;
    }

    public String num1To99999999(int num) {
        if (num < 1 || num > 99999999) {
            return "";
        }
        int wan = num / 10000;
        int rest = num % 10000;
        if (wan == 0) {
            return num1To9999(num);
        }
        String res = num1To9999(wan) + "万";
        if (rest == 0) {
            return res;
        } else {
            if (rest < 1000) {
                return res + "零" + num1To999(rest);
            } else {
                return num1To9999(rest);
            }
        }
    }

    public String getNumChiExp(int num) {
        if (num == 0) {
            return "零";
        }
        String res = num < 0 ? "负" : "";
        int yi = Math.abs(num / 100000000);
        int rest = Math.abs(num % 100000000);
        if (yi == 0) {
            return res + num1To99999999(rest);
        }
        res += num1To9999(yi) + "亿";
        if (rest == 0) {
            return res;
        } else {
            if (rest < 10000000) {
                return res + "零" + num1To99999999(rest);
            } else {
                return res + num1To99999999(num);
            }
        }
    }
}

/*
求完全二叉树的节点个数
 */
class CompleteBinaryTreeNodeNum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, 1, mostLevel(root, 1));
    }

    public int process(TreeNode node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLevel(node.right, level + 1) == h) {
            return (1 << (h - level)) + process(node.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + process(node.left, level + 1, h);
        }
    }

    public int mostLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }
}

/*
最长递增子序列问题
 */
class MostLengthSubArray {
    // 经典动态规划
    public int solution(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        return dp[arr.length - 1];
    }
}

/*
神奇数列
1 12 123 1234 12345 ... 1234567891011... 1234567891011...2021...9899100101
给定两个端点，代表数列第l到r，求有多少个可以被3整除的数
 */
