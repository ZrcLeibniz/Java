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
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列里拿出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				circleArrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("请输入一个数字:");
				int value = scanner.nextInt();
				circleArrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = circleArrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = circleArrayQueue.headQueue();
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
			System.out.println("队列已满，添加失败");
			return;
		}
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}

	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空，无法取出数据");
		}
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}

	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列为空");
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
			throw new RuntimeException("队列为空");
		}
		return arr[front];
	}
}