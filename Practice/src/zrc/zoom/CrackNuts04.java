package zrc.zoom;
/*
判断一个数是否为2的整数次幂
 */

import java.util.Scanner;

public class CrackNuts04 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        if ((N & (N - 1)) == 0) {
            System.out.println("是2的整数次幂");
        } else {
            System.out.println("不是2的整数次幂");
        }
    }
}
