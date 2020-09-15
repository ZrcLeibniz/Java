package zrc.test.sort;

import zrc.sort.practice.merge.*;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        Merge17.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
