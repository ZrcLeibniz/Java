package zrc.leetcode;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 291 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class AddStringsSolution {
    public static String addStrings(String num1, String num2) {
        if (num1.equals("0") && num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            result.append(temp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "21";
        String s = addStrings(num1, num2);
        System.out.println(s);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
