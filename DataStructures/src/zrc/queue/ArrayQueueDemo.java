package zrc.queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ������ó�����");
			System.out.println("h(head):�鿴����ͷ������");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������:");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("����ͷ�ĵ�������%d\n", res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
	}

}

class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public ArrayQueue(int arrMaxsize) {
		maxSize = arrMaxsize;
		arr = new int[maxSize];
		front = -1;
		rear = -1;
	}

	public boolean isFull() {
		return rear == maxSize - 1;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�������������ʧ��");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		front++;
		return arr[front];
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ��");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front + 1];
	}
}