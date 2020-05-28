package zrc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSorting {

	public static void main(String[] args) {
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr1 = sf.format(date1);
		System.out.println("排序前的时间是：" + datestr1);
		selectSort(arr);
		Date date2 = new Date();
		String datestr2 = sf.format(date2);
		System.out.println("排序后的时间是：" + datestr2);
	}

	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
//			System.out.println(Arrays.toString(arr));
		}
	}
}
