package zrc.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Demeter02 {

	public static void main(String[] args) {
		SchoolManager schoolManager = new SchoolManager();
		schoolManager.printAllEmployee(new CollegeManager());
	}

}

class EmployeePlus {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

class CollegeEmployeePlus {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

class CollegeManagerPlus {
	public List<CollegeEmployeePlus> getAllEmployeePlus() {
		List<CollegeEmployeePlus> list = new ArrayList<CollegeEmployeePlus>();
		for (int i = 0; i < 10; i++) {
			CollegeEmployeePlus emp = new CollegeEmployeePlus();
			emp.setId("学院员工id=" + i);
			list.add(emp);
		}
		return list;
	}
	
	public void printEmployeePlus() {
		List<CollegeEmployeePlus> list1 = this.getAllEmployeePlus();
		System.out.println("-----------学院员工-----------");
		for(CollegeEmployeePlus e:list1) {
			System.out.println(e.getId());
		}
	}
}

class SchoolManagerPlus {
	public List<EmployeePlus> getAllEmployeePlus() {
		List<EmployeePlus> list = new ArrayList<EmployeePlus>();
		for (int i = 0; i < 5; i++) {
			EmployeePlus emp = new EmployeePlus();
			emp.setId("学校总部员工id=" + i);
			list.add(emp);
		}
		return list;
	}
	
	void printAllEmployee(CollegeManagerPlus sub) {
		sub.printEmployeePlus();
		List<EmployeePlus> list2 = this.getAllEmployeePlus();
		System.out.println("-----------学校总部员工----------");
		for(EmployeePlus e:list2) {
			System.out.println(e.getId());
		}
	}
}