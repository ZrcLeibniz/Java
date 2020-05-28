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
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列里拿出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字:");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头的的数据是%d\n", res);
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
		System.out.println("程序退出");
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
			System.out.println("队列已满，添加失败");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，无法取出数据");
		}
		front++;
		return arr[front];
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		return arr[front + 1];
	}
}