package zrc.flyweightpattern;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebSiteFactory webSiteFactory = new WebSiteFactory();
		WebSite webSiteCategory1 = webSiteFactory.getWebSiteCategory("新闻");
		WebSite webSiteCategory2 = webSiteFactory.getWebSiteCategory("微博");
		WebSite webSiteCategory3 = webSiteFactory.getWebSiteCategory("微博");
		webSiteCategory1.use(new User("张三"));
		webSiteCategory2.use(new User("李四"));
		webSiteCategory3.use(new User("王五"));
		System.out.println(webSiteCategory3 == webSiteCategory2);
	}

}
