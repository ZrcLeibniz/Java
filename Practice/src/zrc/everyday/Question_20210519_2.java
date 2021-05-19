package zrc.everyday;

public class Question_20210519_2 {
    public int solution(int numI, int num2) {
        int sum = numI ^ num2;
        int carry = (numI & num2) << 1;
        if (carry != 0) {
            sum = solution(sum, carry);
        }
        return sum;
    }
}
