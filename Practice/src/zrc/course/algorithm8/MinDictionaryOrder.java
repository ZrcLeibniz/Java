package zrc.course.algorithm8;

import java.util.Arrays;
import java.util.Comparator;

public class MinDictionaryOrder {
    // 对于一个字符串数组而言
    // 将所有的字符串拼接起来，要求字典序最小

    public String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }
        return result.toString();
    }

    private class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
