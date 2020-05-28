package zrc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSorting {

	public static void main(String[] args) {
		int[] arr = new int[80000000];
		for (int i = 0; i < 80000000; i++) {
			arr[i] = (int) (Math.random() * 80000000);
		}
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr1 = sf.format(date1);
		System.out.println("排序前的时间是：" + datestr1);
		quickSort(arr, 0, arr.length-1);
		Date date2 = new Date();
		String datestr2 = sf.format(date2);
		System.out.println("排序后的时间是：" + datestr2);
	}

	public static void quickSort(int arr[], int left, int right) {
		int l = left;
		int r = right;
		int pivot = arr[(left + right) / 2];
		int temp = 0;
		while (l < r) {
			while (arr[l] < pivot) {
				l += 1;
			}
			while (arr[r] > pivot) {
				r -= 1;
			}
			if (l >= r) {
				break;
			} else {
				temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
			// 为了避免序列中有个中轴的值一样的数字造成死循环
			if (arr[l] == pivot) {
				r -= 1;
			}
			if (arr[r] == pivot) {
				l += 1;
			}
		}
		// 避免无限递归，形成栈溢出
		if (l == r) {
			l += 1;
			r -= 1;
		}
		if (left < r) {
			quickSort(arr, left, r);
		}
		if (right > l) {
			quickSort(arr, l, right);
		}
	}
}
