package zrc.creatingpattern.singleton;

public class Singleton_04 {

	public static void main(String[] args) {
		Singleton04 instance1 = Singleton04.getInstance();
		Singleton04 instance2 = Singleton04.getInstance();
		System.out.println(instance1 == instance2);
	}

}

class Singleton04 {
	private static Singleton04 instance;

	private Singleton04() {
	};

	public static synchronized Singleton04 getInstance() {
		if (instance == null) {
			instance = new Singleton04();
		}
		return instance;
	}
}
