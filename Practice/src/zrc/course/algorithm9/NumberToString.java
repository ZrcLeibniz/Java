package zrc.course.algorithm9;

// 规定1对应A、2对应B...
// 给定一个由数字组成字符串，返回有多少种转化的结果
public class NumberToString {
    public int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return solution(str.toCharArray(), 1);
    }

    private int solution(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int result = solution(str, i + 1);
            if (i + 1 < str.length) {
                result += solution(str, i + 2);
            }
            return result;
        }
        if (str[i] == '2') {
            int result = solution(str, i + 1);
            if (i + 1 < str.length && str[i + 1] >= '0' && str[i + 1] <= '6') {
                result += solution(str, i + 2);
            }
            return result;
        }
        return solution(str, i + 1);
    }
}
