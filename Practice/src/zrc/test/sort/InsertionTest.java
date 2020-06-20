package zrc.test.sort;

import zrc.sort.pratice.Insertion.Insertion01;
import zrc.sort.pratice.Insertion.Insertion02;
import zrc.sort.pratice.Insertion.Insertion03;
import zrc.sort.pratice.Insertion.Insertion04;

import java.util.Arrays;

public class InsertionTest {

    public static void main(String[] args) {
        Integer[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        Insertion04.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
