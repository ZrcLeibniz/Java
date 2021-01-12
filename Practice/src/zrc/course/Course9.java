package zrc.course;

import java.util.LinkedList;
import java.util.Queue;

public class Course9 {
    public static void main(String[] args) {
        StrSubsequence strSubsequence = new StrSubsequence();
        int indexOf = strSubsequence.getIndexOf("abcgf", "cgf");
        System.out.println(indexOf);
    }
}

// 求一个字符串的字串
class StrSubsequence {
    // 暴力做法，时间复杂度为O(M*N)
    public int getIndexOf(String str, String target) {
        if (str.length() < target.length()) {
            return -1;
        }
        int index = 0;
        for (; index < str.length(); index++) {
            int black = 0;
            for (int red = index; black < target.length() && red < str.length(); black++, red++) {
                if (str.length() - index < target.length()) {
                    return -1;
                }
                if (str.charAt(red) != target.charAt(black)) {
                    break;
                }
            }
            if (black == target.length()) {
                break;
            }
        }
        return index;
    }

    // 使用KMP算法加速匹配字符串
    public int getIndexOfII(String str, String target) {
        if (str == null || target == null || target.length() < 1 || str.length() < target.length()) {
            return -1;
        }
        char[] str1 = str.toCharArray();
        char[] str2 = target.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}

/*
给定两颗二叉树，判断原树中是否有字树与目标树的结构完全相同
 */
class SubTreeStructure {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private String TreeSerialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String result = root.val + "!";
        result += TreeSerialize(root.left);
        result += TreeSerialize(root.right);
        return result;
    }

    private TreeNode reconTree(String pre) {
        String[] values = pre.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconTree(queue);
    }

    private TreeNode reconTree(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconTree(queue);
        root.right = reconTree(queue);
        return root;
    }

    private int getIndexOf(String str, String target) {
        if (str == null || target == null || target.length() < 1 || str.length() < target.length()) {
            return -1;
        }
        char[] str1 = str.toCharArray();
        char[] str2 = str.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str1.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == target.length() ? i2 - i1 : -1;
    }

    private int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int index = 0;
        int cn = 0;
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        while (index < next.length) {
            if (str[index - 1] == str[cn]) {
                next[index++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }

    public boolean isSubTreeStructure(TreeNode root, TreeNode target) {
        String rootStr = TreeSerialize(root);
        String rootTarget = TreeSerialize(target);
        if (getIndexOf(rootStr, rootTarget) != -1) {
            return true;
        } else {
            return false;
        }
    }
}

// 找到最长的回文字串
class PalindromeString {
    public int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[str.length()];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
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
        return max - 1;
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

    // 衍生题目，往末尾添加长度最短的字符串，使得该字符串变为回文串
    public String shortestEnd(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int index = -1;
        int pR = -1;
        int maxContainsEnd = -1;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > pR) {
                pR = i + pArr[i];
                index = i;
            }
            if (pR == charArr.length) {
                maxContainsEnd = pArr[i];
                break;
            }
        }
        char[] res = new char[str.length() - maxContainsEnd + 1];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = charArr[i * 2 + 1];
        }
        return String.valueOf(res);
    }
}

class BFPRT {
    public int getMinKthByBFPRT(int[] arr, int K) {
        int[] copyArr = copyArray(arr);
        return bfprt(copyArr, 0, copyArr.length - 1, K - 1);
    }

    private int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int bfprt(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, i);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, i);
        }
    }

    private int[] partition(int[] arr, int begin, int end, int pivot) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, --big, cur);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    private int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    private void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            for (int j = i; j > begin; i--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}