package zrc.course.algorithm12;

/*
manacher算法是求解一个字符串中的最长回文字串问题
首先我们需要需要明确一个概念，就是回文半径/直径：
       aabaa的回文半径就是3
       #a#a#b#a#a#的回文直径是11
第二就是最右回文右边界：
    在计算回文长度的过程中，我们会不断从一个字符开始不断向两端扩充，在这个扩充的过程中
    能够到达整个字符串最右的位置就是，最右回文右边界R
第三就是最右回文右边界的中心点，就是在遍历过程中到达最右位置时，我们所计算的字符串中的那个字符
明确概念后，我们就可以加速计算
    (1)当要计算的字符索引i在R的外侧
        直接暴力计算
    (2)当i的位置在R的内侧，首先我们根据R的中心点C做出i的找出i的对称点j
        <1>当j的回文半径在L内， 那么i的回文半径就是j的回文半径
        <2>当j的回文半径在L外，那么i的回文半径就是R-i，此时的R是最右边界的下一个下标
        <3>当j的回文半径与L重合，那么i的回文半径最小是R-i，需要进一步检验
 */
public class Manacher {
    public int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String manacherString = process(s);
        char[] chars = manacherString.toCharArray();
        int C = -1;
        int R = -1;
        int[] length = new int[chars.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            length[i] = i > R ? 1 : Math.min(length[2 * C - i], R - i);
            while (i + length[i] < chars.length && i - length[i] > -1) {
                if (chars[i + length[i]] == chars[i - length[i]]) {
                    length[i]++;
                } else {
                    break;
                }
            }
            if (i + length[i] > R) {
                R = i + length[i];
                C = i;
            }
            max = Math.max(max, length[i]);
        }
        return max - 1;
    }

    public static String process(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < 2 * chars.length + 1; i++) {
            if (i % 2 == 0) {
                result.append("#");
            } else {
                result.append(chars[index++]);
            }
        }
        return result.toString();
    }
}
