package zrc.search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i;
		}
		int index = insertValueSearch(arr, 0, arr.length-1, 1);
		System.out.println(index);
	}

	public static int insertValueSearch(int[] arr, int left, int right, int findval) {
		if (left > right || findval < arr[0] || findval > arr[arr.length - 1]) {
			return -1;
		}
		int mid = left + (right - left) * (findval - arr[left]) / (arr[right] - arr[left]);
		int midval = arr[mid];
		if (findval > midval) {
			return insertValueSearch(arr, mid + 1, right, findval);
		} else if (findval < midval) {
			return insertValueSearch(arr, left, mid - 1, findval);
		} else {
			return mid;
		}
	}

}
