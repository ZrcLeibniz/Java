package zrc.test.sort;

import zrc.sort.Bubble;
import zrc.sort.pratice.bubble.*;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 5, 6, 3, 2, 1};
        Bubble07.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
