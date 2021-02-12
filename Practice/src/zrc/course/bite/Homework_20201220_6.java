package zrc.course.bite;

public class Homework_20201220_6 {
    public static void main(String[] args) {
        Homework_20201220_6 test = new Homework_20201220_6();
        System.out.println(test.getFactorialSum(4));
    }

    public int getFactorialSum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += getFactorial(i);
        }
        return result;
    }

    public int getFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * getFactorial(n - 1);
    }
}
