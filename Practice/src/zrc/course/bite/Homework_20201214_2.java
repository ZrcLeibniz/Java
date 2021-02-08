package zrc.course.bite;

public class Homework_20201214_2 {
    public static void main(String[] args) {
        Homework_20201214_2 test = new Homework_20201214_2();
        System.out.println(test.getMaxGreatestCommonDivisor(24, 8));
    }

    public int getMaxGreatestCommonDivisor(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        int limit = a < b ? a : b;
        for (int i = limit; i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
