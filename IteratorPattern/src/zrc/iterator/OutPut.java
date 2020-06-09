package zrc.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPut {
	List<College> collegeList;

	public OutPut(List<College> collegeList) {
		super();
		this.collegeList = collegeList;
	}

	public void printCollege() {
		Iterator<College> iterator = collegeList.iterator();
		while (iterator.hasNext()) {
			College next = iterator.next();
			System.out.println("=====" + next.getName() + "======");
			printDepartment(next.createIterator());
		}
	}

	public void printDepartment(Iterator iterator) {
		while (iterator.hasNext()) {
			Department d = (Department) iterator.next();
			System.out.println(d.getName());
		}
	}
}
