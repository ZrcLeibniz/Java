package zrc.comprisepattern;

public class Client {
	public static void main(String[] args) {
		OrganizationComponent university = new University("�廪��ѧ", "�й�������ѧ");
		OrganizationComponent college = new College("�����ѧԺ", "Java��ǿ");
		OrganizationComponent college2 = new College("��Ϣ����ѧԺ", "Python��ǿ");
		OrganizationComponent departent1 = new Departent("�������ѧ�뼼��", "Mysql��ǿ");
		OrganizationComponent departent2 = new Departent("�������", "Eclipse��ǿ");
		OrganizationComponent departent3 = new Departent("������", "����");
		college.add(departent1);
		college.add(departent2);
		college.add(departent3);
		university.add(college);
		university.add(college2);
		university.print();
	}
}
