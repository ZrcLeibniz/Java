package zrc.test.sort;

import zrc.sort.practice.shell.*;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 4, 5, 7, 6, 9, 8, 1};
        Shell15.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
