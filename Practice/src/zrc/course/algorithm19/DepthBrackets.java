package zrc.course.algorithm19;

/*
一个合法的括号匹配序列有以下定义
    1.空字符串是完整的
    2.如果s是完整字符串那么(s)也是完整的
    3.如果s和t是完整的字符串，将其连接起来形成的st也是完整的
对于一个合法的括号序列我们由有定义它的深度
    1.空串的深度是0
    2.如果字符串X的深度是x，字符串y的深度是y，那么字符串XY的深度是max(x, y)
    3.如果X的深度是x， 那么字符串(X)的深度是x+1
 */

public class DepthBrackets {
    public int solution(String s) {
        if (!isValid(s)) {
            return -1;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (s.charAt(i) == ')' && --count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
