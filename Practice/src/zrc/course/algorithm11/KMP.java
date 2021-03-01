package zrc.course.algorithm11;

public class KMP {
    public int solution(String source, String target) {
        if (source == null || source == null || target.length() < 1 || source.length() < target.length()) {
            return -1;
        }
        char[] str1 = source.toCharArray();
        char[] str2 = target.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private int[] getNextArray(char[] string) {
        if (string.length == 1) {
            return new int[]{-1};
        }
        int[] result = new int[string.length];
        result[0] = -1;
        result[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < result.length) {
            if (string[i - 1] == string[cn]) {
                result[i++] = ++cn;
            } else if (cn > 0) {
                cn = result[cn];
            } else {
                result[i++] = 0;
            }
        }
        return result;
    }
}
