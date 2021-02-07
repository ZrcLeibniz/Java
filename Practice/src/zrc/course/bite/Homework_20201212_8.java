package zrc.course.bite;

public class Homework_20201212_8 {

    public static void main(String[] args) {
        Homework_20201212_8 test = new Homework_20201212_8();
        for (int i = 0; i < 1000; i++) {
            if (test.isNarcissisticNumber(i)) {
                System.out.println(i);
            }
        }
    }

    public boolean isNarcissisticNumber(int n) {
        if (n < 100) {
            return false;
        }
        int temp = n;
        int ans = 0;
            while (n != 0) {
                ans += (n % 10) * (n % 10) * (n % 10);
                n = n / 10;
            }
        return temp == ans;
    }
}
