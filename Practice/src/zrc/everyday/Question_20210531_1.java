package zrc.everyday;

import java.util.Scanner;

public class Question_20210531_1 {
    public static int solution(String[] log) {
        int result = Integer.MIN_VALUE;
        int link = 0;
        int[] process = process(log);
        for (int i : process) {
            if (i == 1) {
                link++;
            } else {
                link--;
            }
            if (link > result) {
                result = link;
            }
        }
        return result;
    }

    private static int[] process(String[] log) {
        int[] result = new int[log.length];
        int index = 0;
        for (String s : log) {
            if (s.contains("disconnect")) {
                result[index++] = 0;
            } else {
                result[index++] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = Integer.parseInt(scanner.nextLine());
            String[] log = new String[num];
            for (int i = 0; i < log.length; i++) {
                log[i] = scanner.nextLine();
            }
            int solution = solution(log);
            System.out.println(solution);
        }
    }
}
