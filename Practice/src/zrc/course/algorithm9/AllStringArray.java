package zrc.course.algorithm9;

import java.util.ArrayList;

// 打印一个字符串的全排列
// 要求不能出现重复
public class AllStringArray {
    public ArrayList<String> solution(String str) {
        ArrayList<String> result = new ArrayList<>();
        solution(str.toCharArray(), 0, result);
        return result;
    }

    private void solution(char[] str, int i, ArrayList<String> result) {
        if (i == str.length - 1) {
            result.add(new String(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[j - 'a']) {
                visit[j - 'a'] = true;
                swap(str, i, j);
                solution(str, i + 1, result);
                swap(str, i, j);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
