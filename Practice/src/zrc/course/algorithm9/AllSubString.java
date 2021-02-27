package zrc.course.algorithm9;

import java.util.ArrayList;

// 求一个字符串的全部子序列
public class AllSubString {
    public ArrayList<String> solution(String str) {
        ArrayList<String> result = new ArrayList<>();
        solution(str.toCharArray(), 0, result);
        return result;
    }

    private void solution(char[] str, int i, ArrayList<String> result) {
        if (i == str.length - 1) {
            result.add(String.valueOf(str));
            return;
        }
        solution(str, i + 1, result);
        char cur = str[i];
        str[i] = 0;
        solution(str, i + 1, result);
        str[i] = cur;
    }
}
