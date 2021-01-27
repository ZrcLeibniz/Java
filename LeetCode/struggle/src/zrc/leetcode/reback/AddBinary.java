package zrc.leetcode.reback;

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 550 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class AddBinarySolution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int pA = a.length() - 1;
        int pB = b.length() - 1;
        int carry = 0;
        while (pA >= 0 || pB >= 0) {
            int num1 = pA >= 0 ? a.charAt(pA--) - '0' : 0;
            int num2 = pB >= 0 ? b.charAt(pB--) - '0' : 0;
            int sum = num1 + num2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        result = carry == 1 ? result.append(1) : result;
        return result.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
