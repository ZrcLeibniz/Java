package zrc.everyday;

import java.util.Scanner;

public class Question_20210413_1 {
    private static int solution(int[] arr) {
        int[] asc = new int[arr.length];
        int[] desc = new int[arr.length];
        asc[0] = 1;
        desc[0] = 1;
        for (int i = 1; i < asc.length; i++) {
            asc[i] = arr[i] >= arr[i - 1] ? asc[i - 1] + 1 : 1;
            desc[i] = arr[i] <= arr[i - 1] ? desc[i - 1] + 1 : 1;
        }
        int result = 0;
        int index = arr.length - 1;
        while (index >= 0) {
            int pre = Math.max(asc[index], desc[index]);
            index -= pre;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int[] arr = null;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
        }
        int solution = solution(arr);
        System.out.println(solution);
    }
}
