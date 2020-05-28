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
		// 一个二叉树中有arr.length / 2 - 1个非叶子节点
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
		// 第一次for循环是将所有的元素排列成大顶堆
		// 第二次for循环之所以一直从0号节点进行操作，是因为我们只是将堆顶元素进行了变动，所以每次只需要将堆顶元素移动到合适位置即可
		// 而其余元素的顺序没有问题
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
