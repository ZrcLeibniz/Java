package zrc.offer;

import java.util.Arrays;

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序使得所有的奇数位于数组的前半部分，
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class JZ13 {
    public void reOrderArray(int[] array) {
        int[] temp = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                temp[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                temp[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        JZ13 jz13 = new JZ13();
        int[] arr = {2, 5, 7, 3, 5, 8};
        jz13.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
