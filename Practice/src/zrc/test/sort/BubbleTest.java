package zrc.test.sort;

import zrc.sort.practice.bubble.*;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        Bubble33.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
