package zrc.flyweightpattern;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebSiteFactory webSiteFactory = new WebSiteFactory();
		WebSite webSiteCategory1 = webSiteFactory.getWebSiteCategory("����");
		WebSite webSiteCategory2 = webSiteFactory.getWebSiteCategory("΢��");
		WebSite webSiteCategory3 = webSiteFactory.getWebSiteCategory("΢��");
		webSiteCategory1.use(new User("����"));
		webSiteCategory2.use(new User("����"));
		webSiteCategory3.use(new User("����"));
		System.out.println(webSiteCategory3 == webSiteCategory2);
	}

}
