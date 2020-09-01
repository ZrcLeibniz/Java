package zrc.offer;
/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

import java.util.ArrayList;

public class JZ27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) {
            return result;
        } else {
            association(str, "", result);
            return result;
        }
    }

    private void association(String str, String cur, ArrayList<String> result) {
        if (str.length() == 0) {
            if (!result.contains(cur)) {
                result.add(cur);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            association(str.substring(0, i) + str.substring(i + 1, str.length()), cur + str.charAt(i), result);
        }
    }
}
