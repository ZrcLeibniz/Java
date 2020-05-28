package zrc.queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
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
				circleArrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("������һ������:");
				int value = scanner.nextInt();
				circleArrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = circleArrayQueue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = circleArrayQueue.headQueue();
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

class CircleArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;

	public CircleArrayQueue(int arrMaxsize) {
		maxSize = arrMaxsize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;
	}

	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}

	public boolean isEmpty() {
		return rear == front;
	}

	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("�������������ʧ��");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ��޷�ȡ������");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("����Ϊ��");
		}
		for (int i = front; i < front+size();i++ ) {
			System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
		}
	}

	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		return arr[front];
	}
}