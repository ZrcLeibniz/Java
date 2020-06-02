package zrc.staticproxy;

public class Client {
	public static void main(String[] args) {
		TeachDao teachDao = new TeachDao();
		TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teachDao);
		teacherDaoProxy.teach();
	}
}
