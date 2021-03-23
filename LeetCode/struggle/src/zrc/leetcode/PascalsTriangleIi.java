package zrc.leetcode;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 271 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PascalsTriangleIISolution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            result.add(new ArrayList<>());
        }
        result.get(0).add(1);
        for (int i = 1; i < rowIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                int num1 = j - 1 < 0 ? 0 : result.get(i - 1).get(j - 1);
                int num2 = j == i ? 0 : result.get(i - 1).get(j);
                result.get(i).add(num1 + num2);
            }
        }
        return result.get(rowIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
