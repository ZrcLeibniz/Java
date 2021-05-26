package zrc.everyday;

import java.util.Scanner;

public class Question_20210527_1 {
    public static int solution(String big, String small) {
        if (!big.contains(small)) {
            return 0;
        }
        int begin = big.indexOf(small);
        return 1 + solution(big.substring(begin + small.length()), small);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String big = scanner.next();
            String small = scanner.next();
            int solution = solution(big, small);
            System.out.println(solution);
        }
    }
}
