package zrc.onedimensional;

import java.util.Scanner;

public class ArrayTest02 {
    public static void main(String[] args) {
        int[] a = new int[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.println("请输入数字：");
            int temp = scanner.nextInt();
            a[i] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
