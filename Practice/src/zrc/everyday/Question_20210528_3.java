package zrc.everyday;

import java.util.Scanner;

public class Question_20210528_3 {
    private static double mother(int people) {
        if (people == 0) {
            return 1;
        }
        return people * mother(people - 1);
    }

    private static double son(int people) {
        if (people == 1) {
            return 0;
        }
        if (people == 2) {
            return 1;
        }
        return (people - 1) * (son(people - 1) + son(people - 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int people = scanner.nextInt();
            double mother = mother(people);
            double son = son(people);
            double result = son / mother * 100;
            System.out.println(String.format("%.2f", result) + "%");
        }
    }
}
