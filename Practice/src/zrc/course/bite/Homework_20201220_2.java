package zrc.course.bite;

public class Homework_20201220_2 {
    public static void main(String[] args) {
        Homework_20201220_2 test = new Homework_20201220_2();
        System.out.println(test.getMax(1, 2));
        System.out.println(test.getMax(3.1, 8.4));
        System.out.println(test.getMax(2, 6.5, 3.5));
    }

    public int getMax(int a, int b) {
        return a > b ? a : b;
    }

    public double getMax(double a, double b) {
        return a > b ? a : b;
    }

    public double getMax(int a, double b, double c) {
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b > c) {
                return b;
            } else {
                return c;
            }
        }
    }
}
