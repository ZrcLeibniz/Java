package zrc.test.sort;

import zrc.sort.Heap;
import zrc.sort.practice.heap.Heap01;
import zrc.sort.practice.heap.Heap02;
import zrc.sort.practice.heap.Heap03;

import java.util.Arrays;

public class HeapTest {
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        Heap03.sort(arr);
        System.out.print(Arrays.asList(arr) + " ");
    }
}
