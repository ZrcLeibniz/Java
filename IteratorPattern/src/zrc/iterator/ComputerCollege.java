package zrc.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

	Department[] departments;

	int numOfDepartment = 0;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "计算机学院";
	}

	public ComputerCollege() {
		departments = new Department[5];
		addDepartment("Java", "很强");
		addDepartment("PHP", "很强");
		addDepartment("C", "很强");
		addDepartment("C++", "很强");
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
