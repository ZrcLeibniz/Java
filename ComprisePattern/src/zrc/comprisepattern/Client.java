package zrc.comprisepattern;

public class Client {
	public static void main(String[] args) {
		OrganizationComponent university = new University("清华大学", "中国顶级大学");
		OrganizationComponent college = new College("计算机学院", "Java很强");
		OrganizationComponent college2 = new College("信息工程学院", "Python很强");
		OrganizationComponent departent1 = new Departent("计算机科学与技术", "Mysql很强");
		OrganizationComponent departent2 = new Departent("软件工程", "Eclipse很强");
		OrganizationComponent departent3 = new Departent("物联网", "垃圾");
		college.add(departent1);
		college.add(departent2);
		college.add(departent3);
		university.add(college);
		university.add(college2);
		university.print();
	}
}
