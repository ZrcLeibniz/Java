package zrc.everyday;

import java.util.Scanner;

public class Question_20210519_1 {
    public static boolean solution(double r, double cat) {
        return 3.14 * r * 2 > cat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double cat = scanner.nextDouble();
            double r = scanner.nextDouble();
            boolean solution = solution(r, cat);
            if (solution) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
