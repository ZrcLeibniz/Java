package zrc.test.sort;

import zrc.sort.Quick;
import zrc.sort.pratice.quick.Quick01;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick01.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
