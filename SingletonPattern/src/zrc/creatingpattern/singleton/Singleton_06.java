package zrc.creatingpattern.singleton;

public class Singleton_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Singleton06 {
	private static volatile Singleton06 instance;

	private Singleton06() {
	};

	public static Singleton06 getInstance() {
		if (instance == null) {
			synchronized (Singleton06.class) {
				if (instance == null) {
					instance = new Singleton06();
				}
			}
		}
		return instance;
	}
}