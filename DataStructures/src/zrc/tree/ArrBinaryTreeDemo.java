package zrc.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
		arrayBinaryTree.preOrder(0);
	}

}

class ArrayBinaryTree {
	private int[] arr;

	public ArrayBinaryTree(int[] arr) {
		this.arr = arr;
	}

	public void preOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
			return;
		}
		System.out.println(arr[index]);
		if ((index * 2 + 1) < arr.length) {
			preOrder(2 * index + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(2 * index + 2);
		}
	}

	public void infixOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն��������������");
			return;
		}
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		System.out.println(arr[index]);
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 1);
		}
	}

	public void postOrder(int index) {
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�գ����ܰ��ն������ĺ������");
			return;
		}
		if ((index * 2 + 1) < arr.length) {
			preOrder(index * 2 + 1);
		}
		if ((index * 2 + 2) < arr.length) {
			preOrder(index * 2 + 2);
		}
		System.out.println(arr[index]);
	}

}