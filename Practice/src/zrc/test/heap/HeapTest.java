package zrc.test.heap;

import zrc.heap.Heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap<String> heap = new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");
        heap.insert("H");
        heap.insert("I");
        heap.insert("J");
        while(heap.getN() > 0) {
            System.out.println(heap.delMax());
        }
    }
}
