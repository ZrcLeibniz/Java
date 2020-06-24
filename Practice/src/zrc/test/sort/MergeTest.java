package zrc.test.sort;

import zrc.sort.Merge;
import zrc.sort.pratice.merge.Merge01;
import zrc.sort.pratice.merge.Merge02;
import zrc.sort.pratice.merge.Merge03;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        Merge03.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
