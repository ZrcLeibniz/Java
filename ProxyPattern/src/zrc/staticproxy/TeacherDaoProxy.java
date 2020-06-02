package zrc.staticproxy;

public class TeacherDaoProxy implements ITeacherDao {
	private ITeacherDao target;

	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println("代理对象开始代理");
		target.teach();
		System.out.println("代理结束");
	}

	public TeacherDaoProxy(ITeacherDao target) {
		super();
		this.target = target;
	}

}
