package zrc.test.sort;

import zrc.sort.practice.quick.*;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick13.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
