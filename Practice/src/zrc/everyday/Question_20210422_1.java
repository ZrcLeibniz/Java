package zrc.everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question_20210422_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int solution = solution(N);
            System.out.println(solution);
        }
    }

    public static int solution(int N) {
        int index = 2;
        List<Integer> table = new ArrayList<>();
        table.add(0);
        table.add(1);
        int opt = Math.min(Math.abs(N - table.get(0)), Math.abs(N - table.get(1)));
        while (true) {
            int sum = table.get(index - 1) + table.get(index - 2);
            opt = Math.min(opt, Math.abs(N - sum));
            index++;
            table.add(sum);
            if (sum > N) {
                break;
            }
        }
        return opt;
    }
}
