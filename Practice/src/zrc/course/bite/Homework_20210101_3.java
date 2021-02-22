package zrc.course.bite;

public class Homework_20210101_3 {
    public static void main(String[] args) {
        Homework_20210101_3 test = new Homework_20210101_3();
        int[] arr = {1, 3, 5, 7, 9, 10};
        System.out.println(test.binarySearch(arr, 9, 0, arr.length - 1));
    }

    public int binarySearch(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                return binarySearch(arr, target, left, mid - 1);
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, mid + 1, right);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
