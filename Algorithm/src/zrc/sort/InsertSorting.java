package zrc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSorting {
	public static void main(String[] args) {
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr1 = sf.format(date1);
		System.out.println("排序前的时间是：" + datestr1);
		insertSort(arr);
		Date date2 = new Date();
		String datestr2 = sf.format(date2);
		System.out.println("排序后的时间是：" + datestr2);
	}

	public static void insertSort(int[] arr) {
		int insertValue = 0;
		int insertIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			insertValue = arr[i];
			insertIndex = i - 1;
			while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			if(insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertValue;
			}
			// System.out.println(Arrays.toString(arr));
		}
	}
}