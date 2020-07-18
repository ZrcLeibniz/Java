package zrc.test.sort;

import zrc.sort.Heap;

import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Heap.sort(arr);
        System.out.print(Arrays.asList(arr) + " ");
    }
}
