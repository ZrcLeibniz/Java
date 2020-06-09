package zrc.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

	Department[] departments;

	int numOfDepartment = 0;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "�����ѧԺ";
	}

	public ComputerCollege() {
		departments = new Department[5];
		addDepartment("Java", "��ǿ");
		addDepartment("PHP", "��ǿ");
		addDepartment("C", "��ǿ");
		addDepartment("C++", "��ǿ");
	}

	@Override
	public void addDepartment(String name, String desc) {
		// TODO Auto-generated method stub
		Department department = new Department(name, desc);
		departments[numOfDepartment] = department;
		numOfDepartment += 1;
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new ComputerCollegeIterator(departments);
	}

}
