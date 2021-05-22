package zrc.everyday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Question_20210522_2 {
    public static int solution(int num) {
        List<Integer> list = process(num);
        if (list.size() == 0) {
            return 1;
        }
        int count = 0;
        for (Integer integer : list) {
            if (process(integer).size() == 0) {
                count++;
            }
        }
        return count;
    }

    private static List<Integer> process(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                result.add(i);
                if (num / i != i) {
                    result.add(num / i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int solution = solution(num);
            System.out.println(solution);
        }
    }
}

