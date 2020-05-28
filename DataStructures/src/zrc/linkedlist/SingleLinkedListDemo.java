package zrc.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		HeroNode node1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode node2 = new HeroNode(2, "¬����", "������");
		HeroNode node3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode node4 = new HeroNode(4, "����ʤ", "������");
		HeroNode newHeroNode = new HeroNode(3, "��ʤ", "��");
		HeroNode oldHeroNode = new HeroNode(3, "��ʤ", "��");
		HeroNode finnalNode = new HeroNode(3, "����", "�Ƕ���");
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addByOrder(node1);
		singleLinkedList.addByOrder(node4);
		singleLinkedList.addByOrder(node2);
		singleLinkedList.addByOrder(node3);
		singleLinkedList.list();
		reversePrint(singleLinkedList.getHead());
		reverseList(singleLinkedList.getHead());
		singleLinkedList.list();
//		singleLinkedList.update(newHeroNode);
//		singleLinkedList.delete(oldHeroNode);
//		singleLinkedList.addByOrder(finnalNode);
//		singleLinkedList.delete(1);
//		singleLinkedList.delete(4);
//		singleLinkedList.delete(2);
//		singleLinkedList.delete(3);
//		int n = getLength(singleLinkedList.getHead());
//		singleLinkedList.add(node1);
//		singleLinkedList.add(node2);
//		singleLinkedList.add(node3);
//		singleLinkedList.add(node4);
//		singleLinkedList.list();
//		System.out.println(n);
//		HeroNode node = findLastNode(singleLinkedList.getHead(), 2);
//		System.out.println(node);
	}
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null) { 
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	public static HeroNode findLastNode(HeroNode head, int lastIndex) {
		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		if(lastIndex <= 0 || lastIndex > size) {
			return null;
		}
		HeroNode temp = head.next;
		while(true) {
			if(temp.no == size-lastIndex+1) {
				return temp;
			}else {
				temp = temp.next;
			}
		}
	}
	
	public static void reverseList(HeroNode head) {
		if(head.next == null || head.next.next == null) {
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while(cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
	} 
	
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		Stack<HeroNode> stack  = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}

class SingleLinkedList {
	private HeroNode head = new HeroNode(0, "", "");
	
	public HeroNode getHead() {
		return head;
	}

	public void setHead(HeroNode head) {
		this.head = head;
	}

	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}

	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			} else if (temp.next.no > heroNode.no) {
				break;
			} else if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("Ӣ�۱���Ѵ���" + heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	public void update(HeroNode newHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			} else if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.println("û���ҵ��ñ�ŵĽڵ�");
		}
	}

	public void delete(HeroNode oldHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			} else if (temp.next.no == oldHeroNode.no) {
				flag = true;
				break;
			} else if (temp.next.no > oldHeroNode.no) {
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("Ҫɾ���Ľڵ㲻����");
		}
	}

	public void delete(int no) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
		}
		HeroNode temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			} else if (temp.next.no == no) {
				flag = true;
				break;
			} else if (temp.next.no > no) {
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("Ҫɾ���Ľڵ㲻����");
		}
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}