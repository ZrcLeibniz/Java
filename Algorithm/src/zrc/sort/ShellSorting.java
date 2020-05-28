package zrc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSorting {
	public static void main(String[] args) {
		int[] arr = new int[80000000];
		for (int i = 0; i < 80000000; i++) {
			arr[i] = (int) (Math.random() * 80000000);
		}
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr1 = sf.format(date1);
		System.out.println("排序前的时间是：" + datestr1);
		shellSort(arr);
		Date date2 = new Date();
		String datestr2 = sf.format(date2);
		System.out.println("排序后的时间是：" + datestr2);
	}

	public static void shellSort(int[] arr) {
		int temp = 0;
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
				// System.out.println(i);
				// System.out.println(Arrays.toString(arr));
			}
		}
		// System.out.println("第二趟");
		// for (int i = 2; i < arr.length; i++) {
		// for (int j = i - 2; j >= 0; j -= 2) {
		// if (arr[j] > arr[j + 2]) {
		// temp = arr[j];
		// arr[j] = arr[j + 2];
		// arr[j + 2] = temp;
		// }
		// System.out.println("i"+i);
		// System.out.println(j);
		// System.out.println(Arrays.toString(arr));
		// }
		// System.out.println(Arrays.toString(arr));
		// }
	}

	public static void shellSort2(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp;
				}
			}
		}
	}
}
