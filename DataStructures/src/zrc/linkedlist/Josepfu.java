package zrc.linkedlist;

import java.lang.reflect.Field;

public class Josepfu {

	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
		circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1, 2, 5);
	}

}

class CircleSingleLinkedList {
	private Boy first = null;

	public void addBoy(int nums) {
		if (nums < 1) {
			System.out.println("num的值不正确");
			return;
		} else {
			Boy curBoy = null;
			for (int i = 1; i <= nums; i++) {
				Boy boy = new Boy(i);
				if (i == 1) {
					first = boy;
					first.setNext(first);
					curBoy = first;
				} else {
					curBoy.setNext(boy);
					boy.setNext(first);
					curBoy = boy;
				}
			}
		}
	}

	public void showBoy() {
		if (first == null) {
			System.out.println("循环链表为空");
			return;
		} else {
			Boy curBoy = first;
			while (true) {
				System.out.println("目前节点的编号为:" + curBoy.getNo());
				if (curBoy.getNext() == first) {
					break;
				} else {
					curBoy = curBoy.getNext();
				}
			}
		}
	}

	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误，请重新输入");
			return;
		} else {
			Boy helper = first;
			while (true) {
				if (helper.getNext() == first) {
					break;
				} else {
					helper = helper.getNext();
				}
			}
			for (int i = 0; i < startNo - 1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			while (true) {
				if (helper == first) {
					break;
				} else {
					for(int i=0;i<countNum-1;i++) {
						first = first.getNext();
						helper = helper.getNext();
					}
					System.out.printf("编号为%d的节点出圈\n", first.getNo());
					first = first.getNext();
					helper.setNext(first);
				}
			}
			System.out.printf("最后留在圈中的节点编号是%d\n", first.getNo());
		}
	}

}

class Boy {
	private int no;
	private Boy next;

	public Boy(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}