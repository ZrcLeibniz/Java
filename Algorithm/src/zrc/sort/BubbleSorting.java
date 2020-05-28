package zrc.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSorting {
	public static void main(String[] args) {
		// int arr[] = { 3, 9, -1, 10, 20 };
		// bubbleSort(arr);
		// System.out.println(Arrays.toString(arr));
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr1 = sf.format(date1);
		System.out.println("排序前的时间是：" + datestr1);
		bubbleSort(arr);
		Date date2 = new Date();
		String datestr2 = sf.format(date2);
		System.out.println("排序后的时间是：" + datestr2);
	}

	public static void bubbleSort(int[] arr) {
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - (i + 1); j++) {
				if (arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!flag) {
				break;
			} else {
				flag = false;
			}
		}
	}
}
