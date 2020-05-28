package zrc.creatingpattern.singleton;

public class Singleton_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Singleton07 {
	private Singleton07() {
	};

	private static class SingletonInstance {
		private static final Singleton07 Instance = new Singleton07();
	}

	public static Singleton07 getInstance() {
		return SingletonInstance.Instance;
	}
}