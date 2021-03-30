package zrc.course.algorithm19;

/*
给定一个字符串
    1---a
    2---b
      .
      .
      .
    26--z
编写一个函数求可以转换的不同字符串的个数
例如:12258可以转换的个数是5
 */
public class IntegerToString {
    public int solution(int num) {
        return process(String.valueOf(num).toCharArray(), 0);
    }

    private int process(char[] s, int index) {
        if (index == s.length) {
            return 1;
        }
        if (s[index] == '0') {
            return 0;
        }
        int res = process(s, index + 1);
        if (index == s.length - 1) {
            return res;
        }
        if (((s[index] - '0') * 10 + s[index + 1] - '0') < 27) {
            res += process(s, index + 2);
        }
        return res;
    }
}
