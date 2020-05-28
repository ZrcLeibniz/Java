package zrc.search;

import java.util.ArrayList;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 10, 89, 100, 1234 };
		int index = binarySearch(arr, 0, arr.length - 1, 8);
		System.out.println(index);
	}

	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) {
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return binarySearch(arr, left, mid + 1, findVal);
		} else {
			return mid;
		}
	}

	public static ArrayList binarySearch2(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return new ArrayList<>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) {
			return binarySearch2(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) {
			return binarySearch2(arr, left, mid + 1, findVal);
		} else {
			ArrayList<Integer> resIndexList = new ArrayList<>();
			int temp = mid - 1;
			while (true) {
				if (temp < 0 || arr[temp] != findVal) {
					break;
				} else {
					resIndexList.add(temp);
					temp -= 1;
				}
			}
			resIndexList.add(mid);
			temp = mid + 1;
			while (true) {
				if (temp > arr.length - 1 || temp != findVal) {
					break;
				} else {
					resIndexList.add(temp);
					temp += 1;
				}
			}
			return resIndexList;
		}
	}
}
