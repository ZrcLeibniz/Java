package zrc.leetcode;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 739 👎 0

/*
1.对数组进行遍历，如果是0的话，把所有数组向前一个索引拷贝一份，然后在最后的位置插入0
    时间复杂度：O(n^2)

2.定义一个变量来记录数组的长度，之后对数组进行遍历，重新给数组的各个位置赋值，只要不是0就按照顺寻给数组重新赋值，
定义一个计数器，记录进行了几次操作，数组长度-操作次数+1就是需要补0的个数，
    时间复杂度：O(n)
 */

//leetcode submit region begin(Prohibit modification and deletion)
class MoveZerosSolution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        int num = length - (index + 1);
        for (int i = 0; i < num + 1; i++) {
            nums[index + i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
