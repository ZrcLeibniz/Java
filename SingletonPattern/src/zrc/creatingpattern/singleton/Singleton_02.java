package zrc.creatingpattern.singleton;

public class Singleton_02 {
	public static void main(String[] args) {
		Singleton02 instance1 = Singleton02.getInstance();
		Singleton02 instance2 = Singleton02.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}
}

class Singleton02 {
	private static Singleton02 instance;

	private Singleton02() {

	}

	static {
		instance = new Singleton02();
	}

	public static Singleton02 getInstance() {
		return instance;
	}
}