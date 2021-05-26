package zrc.everyday;

import java.util.Scanner;

public class Question_20210525_2 {

    static int[] fib = new int[100001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        fib[0] = 1;
        fib[1] = 1;
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.printf((n < 25 ? "%d\n" : "%06d\n"), getFibonacci(n));
        }
        in.close();
    }

    static int getFibonacci(int n) {
        if (fib[2] == 0) {
            for (int i = 2; i < 100001; i++) {
                fib[i] = (fib[i - 1] + fib[i - 2]) % 1000000;
            }
        }
        return fib[n];
    }
}
