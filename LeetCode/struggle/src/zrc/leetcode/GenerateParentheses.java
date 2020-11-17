package zrc.leetcode;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1419 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesesSolution {
    private ArrayList<String> result = new ArrayList<>();

    private List<String> generateParenthesis(int n) {
        generate(0, 0, 3, "");
        return result;
    }

    private void generate(int left, int right, int n, String cur) {
        if (left == n && right == n) {
            result.add(cur);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, cur + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, cur + ")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
