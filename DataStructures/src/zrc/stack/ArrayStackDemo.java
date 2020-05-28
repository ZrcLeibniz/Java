package zrc.stack;

import java.util.Scanner;

public class ArrayStackDemo {
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while (loop) {
			System.out.println("show:表示显示栈");
			System.out.println("exit:表示退出栈");
			System.out.println("push:表示添加数据到栈");
			System.out.println("pop:表示从栈取出数据");
			System.out.println("请输入你的选择：");
			key = scanner.next();
			switch (key) {
			case "show":
				arrayStack.list();
				break;
			case "push":
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				arrayStack.push(value);
				break;
			case "pop":
				try {
					int res = arrayStack.pop();
					System.out.println(res);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
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

class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("栈的存储空间已满");
			return;
		} else {
			top++;
			stack[top] = value;
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空");
		} else {
			int value = stack[top];
			top--;
			return value;
		}
	}

	public void list() {
		if (isEmpty()) {
			System.out.println("栈空");
			return;
		} else {
			for (int i = top; i >= 0; i--) {
				System.out.printf("stack[%d]=[%d]\n", i, stack[i]);
			}
		}
	}
}