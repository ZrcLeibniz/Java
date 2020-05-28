package zrc.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
		System.out.println("˫������Ĳ���");
		DoubleHeroNode node1 = new DoubleHeroNode(1, "�ν�", "��ʱ��");
		DoubleHeroNode node2 = new DoubleHeroNode(2, "¬����", "������");
		DoubleHeroNode node3 = new DoubleHeroNode(3, "����", "�Ƕ���");
		DoubleHeroNode node4 = new DoubleHeroNode(4, "����ʤ", "������");
		DoubleHeroNode node5 = new DoubleHeroNode(4, "�ֳ�", "����ͷ");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(node1);
		doubleLinkedList.add(node2);
		doubleLinkedList.add(node3);
		doubleLinkedList.add(node4);
		doubleLinkedList.list();
		doubleLinkedList.update(node5);
		doubleLinkedList.list();
		doubleLinkedList.delete(4);
		doubleLinkedList.list();
		doubleLinkedList.delete(1);
		doubleLinkedList.list();
	}
}

class DoubleLinkedList {
	private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

	
	
	public DoubleHeroNode getHead() {
		return head;
	}

	public void list() {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		} else {
			DoubleHeroNode temp = head.next;
			while (true) {
				if (temp == null) {
					break;
				} else {
					System.out.println(temp);
					temp = temp.next;
				}
			}
		}
	}

	public void add(DoubleHeroNode heroNode) {
		DoubleHeroNode temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			} else {
				temp = temp.next;
			}
		}
		temp.next = heroNode;
		heroNode.per = temp;
	}

	public void update(DoubleHeroNode heroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		} else {
			DoubleHeroNode temp = head.next;
			Boolean flag = false;
			while (true) {
				if (temp == null) {
					break;
				} else if (temp.no == heroNode.no) {
					flag = true;
					break;
				} else {
					temp = temp.next;
				}
			}
			if (flag) {
				temp.name = heroNode.name;
				temp.nickname = heroNode.nickname;
			} else {
				System.out.println("û���ҵ��ýڵ�");
			}
		}
	}

	public void delete(int no) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		} else {
			DoubleHeroNode temp = head.next;
			boolean flag = true;
			while (true) {
				if (temp == null) {
					break;
				} else if (temp.no == no) {
					flag = true;
					break;
				} else {
					temp = temp.next;
				}
			}
			if (flag) {
				temp.per.next = temp.next;
				if (temp.next != null) {
					temp.next.per = temp.per;
				}
			} else {
				System.out.println("Ҫɾ���Ľڵ㲻���� ");
			}
		}
	}
}

class DoubleHeroNode {
	public int no;
	public String name;
	public String nickname;
	public DoubleHeroNode per;
	public DoubleHeroNode next;

	public DoubleHeroNode(int no, String name, String nickname) {
		super();
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "DoubleHeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}