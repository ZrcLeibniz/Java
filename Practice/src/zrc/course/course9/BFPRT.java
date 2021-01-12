package zrc.course.course9;

public class BFPRT {
    public int getMinKthOfBFPRT(int[] arr, int K) {
        int[] copyArr = copyArray(arr);
        return bfprt(copyArr, 0, arr.length - 1, K - 1);
    }

    private int bfprt(int[] arr, int begin, int end, int K) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (K >= pivotRange[0] && K <= pivotRange[1]) {
            return arr[K];
        } else if (K < pivotRange[0]) {
            return bfprt(arr, begin, pivotRange[0] - 1, K);
        } else {
            return bfprt(arr, pivotRange[1] + 1, end, K);
        }
    }

    private int medianOfMedians(int[] arr, int begin, int end) {
       int num = end - begin + 1;
       int offset = num % 5 == 0 ? 0 : 1;
       int[] medianArr = new int[num / 5 + offset];
       for (int i = 0; i < medianArr.length; i++) {
           int beginI = begin + i * 5;
           int endI = beginI + 4;
           medianArr[i] = getMedian(arr, beginI, endI);
       }
       return bfprt(medianArr, 0, medianArr.length - 1, medianArr.length / 2);
    }

    private int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    private void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            for (int j = i; j > begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    private int[] partition(int[] arr, int begin, int end, int pivot) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivot) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivot) {
                swap(arr, --end, cur);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] copyArray(int[] arr) {
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }
}
