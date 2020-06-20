package zrc.test.sort;

import zrc.sort.Selection;
import zrc.sort.pratice.selection.*;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4, 6, 8, 7, 9, 2, 10, 1};
        Selection05.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
