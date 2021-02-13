package zrc.course.bite;

public class Homework_20210101_2 {
    public static void main(String[] args) {
        Homework_20210101_2 test = new Homework_20210101_2();
        int[] arr = {1, 1, 2, 2, 3, 4, 5, 3, 6, 7};
        int[] arr2 = {1, 3, 4, 6, 7, 8, 9, 10};
        System.out.println(test.isSorted(arr));
        System.out.println(test.isSorted(arr2));
    }

    public boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
