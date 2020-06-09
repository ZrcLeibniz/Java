package zrc.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

	List<Department> departments;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "信息学院";
	}

	public InfoCollege() {
		departments = new ArrayList<Department>();
		addDepartment("通信", "很强");
		addDepartment("拉电线", "很强");
		addDepartment("修电杆", "很强");
		addDepartment("换路灯", "很强");
	}

	@Override
	public void addDepartment(String name, String desc) {
		// TODO Auto-generated method stub
		Department department = new Department(name, desc);
		departments.add(department);
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new InfoCollegeIterator(departments);
	}

}
