package zrc.leetcode.reback;

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
// 👍 1515 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesesSolution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, "", n, 0, 0);
        return result;
    }

    private void generateParenthesis(List<String> result, String cur, int n, int left, int right) {
        if (left == n && right == n) {
            result.add(cur);
            return;
        }
        if (left < n) {
            generateParenthesis(result, cur + "(", n, left + 1, right);
        }
        if (right < left) {
            generateParenthesis(result, cur + ")", n, left, right + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
