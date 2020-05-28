package zrc.hash;

import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable hashTable = new HashTable(7);
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add:添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("find:查找雇员");
			System.out.println("exit:退出系统");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTable.add(emp);
				break;
			case "list":
				hashTable.list();
				break;
			case "find":
				System.out.println("请输入要查找的id");
				id = scanner.nextInt();
				hashTable.findEmpById(id);
				break;
			case "exit":
				scanner.close();
				System.out.println("exit");
			default:
				break;
			}
		}

	}

}

class HashTable {
	private EmpLinkedList[] empLinkedListArray;
	private int size;

	public HashTable(int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}

	public void add(Emp emp) {
		int empLinkedListNo = hash(emp.id);
		empLinkedListArray[empLinkedListNo].add(emp);
	}

	public int hash(int id) {
		return id % size;
	}

	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i].list(i);
			System.out.println();
		}
	}

	public void findEmpById(int id) {
		int empLinkedListNo = hash(id);
		Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
		if (emp != null) {
			System.out.printf("在%d条链表找到该雇员,id=%d", empLinkedListNo + 1, id);
		} else {
			System.out.println("没有找到该雇员");
		}
	}
}

class EmpLinkedList {
	private Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		} else {
			Emp curEmp = head;
			while (curEmp.next != null) {
				curEmp = curEmp.next;
			}
			curEmp.next = emp;
		}
	}

	public void list(int no) {
		if (head == null) {
			System.out.print("第" + (no + 1) + "链表为空");
			return;
		} else {
			System.out.print("第条" + (no + 1) + "链表的信息为");
			Emp curEmp = head;
			while (curEmp != null) {
				System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
				curEmp = curEmp.next;
			}
		}
	}

	public Emp findEmpById(int id) {
		if (head == null) {
			System.out.println("当前链表为空");
			return null;
		} else {
			Emp curEmp = head;
			while (true) {
				if (curEmp.id == id) {
					break;
				} else {
					if (curEmp.next == null) {
						curEmp = null;
					} else {
						curEmp = curEmp.next;
					}
				}
			}
			return curEmp;
		}
	}
}

class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}