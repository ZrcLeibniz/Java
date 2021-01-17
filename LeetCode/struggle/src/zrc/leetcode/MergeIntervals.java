package zrc.leetcode;

//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 766 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MergeIntervalsSolution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int index = -1;
        int[][] result = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (index == -1 || result[index][1] < interval[0]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(result, index + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
