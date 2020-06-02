package zrc.staticproxy;

public class TeacherDaoProxy implements ITeacherDao {
	private ITeacherDao target;

	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println("�������ʼ����");
		target.teach();
		System.out.println("�������");
	}

	public TeacherDaoProxy(ITeacherDao target) {
		super();
		this.target = target;
	}

}
