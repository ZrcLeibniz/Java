package zrc.course.algorithm19;

/*
一个完整的括号字符串的定义规则如下：
    1.空字符串是完整的
    2.如果s是完整字符串那么(s)也是完整的
    3.如果s和t是完整的字符串，将其连接起来形成的st也是完整的
先有一个括号字符串s，现在需要在其中任意位置尽量少的添加括号，将其转换为一个完整的括号字符串
求:至少需要添加多少个括号
 */
public class ValidBrackets {
    public int solution(String str) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    ans++;
                } else {
                    count--;
                }
            }
        }
        return count + ans;
    }
}
