package zrc.zoom;

import java.util.Scanner;

/*
输入一个整数。输出该数二进制表示中1的个数
 */
public class CrackNuts03 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        int count = 0;
        while (N != 0) {
            N = (N - 1) & N;
            count++;
        }
        System.out.println(count);
    }
}
