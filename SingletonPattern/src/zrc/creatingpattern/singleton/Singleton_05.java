package zrc.creatingpattern.singleton;

public class Singleton_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Singleton05 {
	private static Singleton05 instance;

	private Singleton05() {
	};

	public static synchronized Singleton05 getInstance() {
		if (instance == null) {
			synchronized (Singleton05.class) {
				instance = new Singleton05();
			}
		}
		return instance;
	}
}
