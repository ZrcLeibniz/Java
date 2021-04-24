package zrc.everyday;

import java.util.Scanner;

public class Question_20210424_3 {

    public static int[] solution(int number) {
        if (number % 2 == 0) {
            int mid = number / 2;
            if (isOdd(mid)) {
                return new int[]{mid, mid};
            } else {
                return getResult(number, mid, mid);
            }
        } else {
            int midI = number / 2;
            int midII = number / 2 + 1;
            if (isOdd(midI) && isOdd(midII)) {
                return new int[]{midI, midII};
            } else {
                return getResult(number, midI, midII);
            }
        }
    }

    private static int[] getResult(int number, int midI, int midII) {
        int pre = getPre(midI);
        int post = getPost(midII);
        while (true) {
            if (pre + post < number) {
                post = getPost(post);
            } else if (pre + post > number) {
                pre = getPre(pre);
            } else {
                return new int[]{pre, post};
            }
        }
    }

    private static boolean isOdd(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int getPre(int pre) {
        int result = pre - 1;
        while (true) {
            if (isOdd(result)) {
                return result;
            }
            result--;
        }
    }

    private static int getPost(int post) {
        int result = post + 1;
        while (true) {
            if (isOdd(result)) {
                return result;
            }
            result++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int[] solution = solution(number);
            for (int i : solution) {
                System.out.println(i);
            }
        }
    }
}
