package zrc.course;

public class Algorithm1 {
    // 冒泡排序
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; i < j; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // 选择排序
    public void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 已知在一个数组中只有一种数出现了奇数次，其余数出现了偶数次，请找出这个数
    public int findNum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

    // 已知在一个数组中有两种数字出现了奇数次，其余数字出现了偶数次，请找出它们
    public int[] findNums(int[] arr) {
        int eor = 0;
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        return new int[] {onlyOne, (eor ^ onlyOne)};
    }

    // 插入排序
    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (!(arr[j] > arr[j - 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    // 在一个有序数组中，找某个数是否存在
    public int findTarget(int[] arr, int target) {
        int mid = arr.length / 2;
        while (mid >= 0 && mid < arr.length) {
            if (arr[mid] > target) {
                mid = mid / 2;
            } else if(arr[mid] < target) {
                mid = (arr.length - mid) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 在一个有序数组中，找大于等于某个数最左侧的位置
    public int findNumLeft(int[] arr, int target) {
        int result = findTarget(arr, target);
        int left = 0;
        if (arr[result] != arr[result - 1]) {
            return result;
        } else {
            int mid = result / 2;
            while (left != result) {
                if (arr[result] < target) {
                    left = mid;
                    mid = (result - left) / 2;
                } else {
                    result = mid;
                }
            }
        }
        return result;
    }
}
