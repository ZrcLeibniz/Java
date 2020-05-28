package zrc.sort;

public class HeapSort {
	public static void main(String[] args) {
		int arr[] = { 4, 6, 8, 5, 9 };
		// adjustHeap(arr, 1, arr.length);
		// adjustHeap(arr, 0, arr.length);
		// for(int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }
		heapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void heapSort(int arr[]) {
		int temp = 0;
		// һ������������arr.length / 2 - 1����Ҷ�ӽڵ�
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		// ��һ��forѭ���ǽ����е�Ԫ�����гɴ󶥶�
		// �ڶ���forѭ��֮����һֱ��0�Žڵ���в���������Ϊ����ֻ�ǽ��Ѷ�Ԫ�ؽ����˱䶯������ÿ��ֻ��Ҫ���Ѷ�Ԫ���ƶ�������λ�ü���
		// ������Ԫ�ص�˳��û������
		for (int j = arr.length - 1; j > 0; j--) {
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
	}

	public static void adjustHeap(int arr[], int i, int length) {
		int temp = arr[i];
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}
}
