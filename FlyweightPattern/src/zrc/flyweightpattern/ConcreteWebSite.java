package zrc.flyweightpattern;

public class ConcreteWebSite extends WebSite {

	private String type = "";

	@Override
	public void use(User user) {
		System.out.println("网站的发布形式为：" + type + "目前是" + user + "在用");
	}

	public ConcreteWebSite(String type) {
		super();
		this.type = type;
	}

}
