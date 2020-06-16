package zrc.array;

public class ArrayTest03 {
    public static void main(String[] args) {
        int[] a = {2, 4, 3, 6, 5, 8, 4, 2, 8};
        ArrayTest03 arrayTest03 = new ArrayTest03();
        arrayTest03.printArray(a);
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
