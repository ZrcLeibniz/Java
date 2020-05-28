package zrc.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FibonacciSearch {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 10, 89, 1000, 1234 };
//		System.out.println(fib(6));
//		ArrayList<Integer> list = fibShow(5);
//		System.out.println(list);
		System.out.println(fibonacciSearch(arr, 1234));
	}

	public static int[] fib2() {
		int[] f = new int[20];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < 20; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static int fib(int k) {
		if (k == 1 || k == 2) {
			return 1;
		} else {
			return fib(k - 1) + fib(k - 2);
		}
	}

	public static ArrayList<Integer> fibShow(int k) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (; k > 0; k--) {
			arrayList.add(fib(k));
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer node : arrayList) {
			stack.push(node);
		}
		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.set(i, stack.pop());
		}
		return arrayList;
	}

	public static int fibonacciSearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int k = 0;
		int[] f = fib2();
		while (high > f[k] - 1) {
			k++;
		}
		int[] temp = Arrays.copyOf(arr, f[k]);
		for (int i = high + 1; i < temp.length; i++) {
			temp[i] = arr[high];
		}
		while (low <= high) {
			mid = low + f[k - 1] - 1;
			if (key < temp[mid]) {
				high = mid - 1;
				k--;
			} else if (key > temp[mid]) {
				low = mid + 1;
				k -= 2;
			}else {
				if(mid < high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}