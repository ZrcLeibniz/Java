package zrc.creatingpattern.singleton;

public class Singleton_01 {
	public static void main(String[] args) {
		Singleton01 instance1 = Singleton01.getInstance();
		Singleton01 instance2 = Singleton01.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}
}

class Singleton01 {
	private Singleton01() {

	}

	private final static Singleton01 instance = new Singleton01();

	public static Singleton01 getInstance() {
		return instance;
	}
}