package zrc.leetcode;
// 77497
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 463 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PascalsTriangleSolution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            result.add(new ArrayList<Integer>(i + 1));
        }
        result.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < i + 1; j++) {
                int num1 = j - 1 < 0 ? 0 : result.get(i - 1).get(j - 1);
                int num2 = j == i ? 0 : result.get(i - 1).get(j);
                result.get(i).add(num1 + num2);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
