package zrc.flyweightpattern;

public class ConcreteWebSite extends WebSite {

	private String type = "";

	@Override
	public void use(User user) {
		System.out.println("��վ�ķ�����ʽΪ��" + type + "Ŀǰ��" + user + "����");
	}

	public ConcreteWebSite(String type) {
		super();
		this.type = type;
	}

}
