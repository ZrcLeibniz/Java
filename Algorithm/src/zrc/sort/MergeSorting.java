package zrc.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSorting {
	public static void main(String[] args) {
		int[] arr = new int[80000000];
		for (int i = 0; i < 80000000; i++) {
			arr[i] = (int) (Math.random() * 80000000);
		}
		Date date1 = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr1 = sf.format(date1);
		System.out.println("����ǰ��ʱ���ǣ�" + datestr1);
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
		Date date2 = new Date();
		String datestr2 = sf.format(date2);
		System.out.println("������ʱ���ǣ�" + datestr2);
	}

	public static void mergeSort(int[] arr, int left, int right, int[] temp) {
		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(arr, left, mid, temp);
			mergeSort(arr, mid + 1, right, temp);
		}
		merge(arr, left, mid, right, temp);
	}

	/**
	 * 
	 * @param arr
	 *            �����ԭʼ����
	 * @param left
	 *            ����������еĳ�ʼ����
	 * @param mid
	 *            �м�����
	 * @param right
	 *            �ұ�����
	 * @param temp
	 *            ����ת������
	 */
	public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left; // ��ʼ��i�� ����������еĳ�ʼ����
		int j = mid + 1; // ��ʼ��j���ұ��������еĳ�ʼ����
		int t = 0; // ָ��temp����ĵ�ǰ����
		// �Ȱ��������ߣ����򣩵����ݰ��չ�����䵽temp����
		// ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			} else {
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		// ����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
		while (i <= mid) {
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while (j <= right) {
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		// ��temp�����Ԫ�ؿ�����arr
		t = 0;
		int tempLeft = left;
		while (tempLeft <= right) {
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;
		}
	}
}