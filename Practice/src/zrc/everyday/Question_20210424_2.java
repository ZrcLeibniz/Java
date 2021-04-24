package zrc.everyday;

public class Question_20210424_2 {
    public static int solution(int n, int m, int j, int i) {
        String source = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
        String target = new StringBuilder(Integer.toBinaryString(m)).reverse().toString();
        int result = 0;
        for (int begin = 0; begin < source.length(); begin++) {
            if (begin >= i && begin <= j) {
                int cur = (begin - i) >= target.length() ? 0 : (int) ((target.charAt(begin - i) - '0') * Math.pow(2, begin));
                result += cur;
            } else {
                result += (source.charAt(begin) - '0') * Math.pow(2, begin);
            }
        }
        return result;
    }
}
