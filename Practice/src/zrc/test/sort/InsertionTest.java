package zrc.test.sort;

import zrc.sort.practice.Insertion.*;

import java.util.Arrays;

public class InsertionTest {

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        Insertion22.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
