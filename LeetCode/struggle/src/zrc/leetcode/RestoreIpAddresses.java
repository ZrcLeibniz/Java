package zrc.leetcode;

//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 521 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class RestoreIPAddressSolution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        Deque<String> path = new ArrayDeque<>(4);
        process(result, path, 0, s);
        return result;
    }

    private void process(List<String> result, Deque<String> path, int begin, String s) {
        if (begin == s.length() && path.size() == 4) {
            result.add(String.join(".", path));
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (s.length() <= i) {
                break;
            }
            if ((4 - path.size())* 3 < s.length() - i) {
                continue;
            }
            if (isValidIP(s, begin, i)) {
                String curIP = s.substring(begin, i + 1);
                path.addLast(curIP);
                process(result, path, i + 1, s);
                path.removeLast();
            }
        }
    }

    private boolean isValidIP(String s, int begin, int end) {
        int length = end - begin + 1;
        if (length > 1 && s.charAt(begin) == '0') {
            return false;
        }
        int result = 0;
        while (begin <= end) {
            result = result * 10 + s.charAt(begin) - '0';
            begin++;
        }
        return result >= 0 && result <= 255;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
