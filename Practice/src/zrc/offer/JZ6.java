package zrc.offer;

import java.util.ArrayList;
import java.util.Collections;

/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class JZ6 {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int lo = 0;
        int hi = array.length - 1;
        while (lo < hi) {
            if (array[lo] < array[hi]) {
                return array[lo];
            }
            int mid = lo + (hi - lo) / 2;
            if (array[hi] > array[mid]) {
                hi = mid;
            } else if (array[hi] < array[mid]) {
                lo = mid + 1;
            } else {
                --hi;
            }
        }
        return array[lo];
    }

    public static int minNumberInRotateArray2(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        Collections.sort(arrayList);
        return arrayList.get(0);
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 1, 2, 3};
        int i = minNumberInRotateArray2(a);
        System.out.println(i);
    }
}
