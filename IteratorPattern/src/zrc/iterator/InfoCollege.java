package zrc.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

	List<Department> departments;

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "��ϢѧԺ";
	}

	public InfoCollege() {
		departments = new ArrayList<Department>();
		addDepartment("ͨ��", "��ǿ");
		addDepartment("������", "��ǿ");
		addDepartment("�޵��", "��ǿ");
		addDepartment("��·��", "��ǿ");
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
