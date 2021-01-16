package zrc.leetcode.reback;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1070 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class LetterCombinationsOfAPhoneNumberSolution {
    static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }
        letterCombinations(result, 0, "", digits);
        return result;
    }

    private void letterCombinations(List<String> result, int index, String cur, String digits) {
        if (digits.length() == cur.length()) {
            result.add(cur);
            return;
        }
        char num = digits.charAt(index);
        String symbol = map[num - '0' - 2];
        for (int i = 0; i < symbol.length(); i++) {
            letterCombinations(result, index + 1, cur + symbol.charAt(i), digits);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
