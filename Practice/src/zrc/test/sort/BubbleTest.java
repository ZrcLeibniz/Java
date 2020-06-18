package zrc.test.sort;

import zrc.sort.Bubble;
import zrc.sort.pratice.bubble.Bubble02;
import zrc.sort.pratice.bubble.Bubble03;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        Bubble03.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
