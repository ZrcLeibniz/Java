package zrc.search;

public class SequenceSearch {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 11, -1, 34, 89 };
		int index = sequenceSearch(11, arr);
		System.out.println(index);
	}

	public static int sequenceSearch(int value, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
