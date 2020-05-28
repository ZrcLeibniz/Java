package zrc.creatingpattern.singleton;

import java.util.ArrayList;

public class Singleton_03 {

	public static void main(String[] args) {
		Singleton03 instance1 = Singleton03.getInstance();
		Singleton03 instance2 = Singleton03.getInstance();
		System.out.println(instance1 == instance2);
	}

}

class Singleton03 {
	private static Singleton03 instance;

	private Singleton03() {
	};

	public static Singleton03 getInstance() {
		if (instance == null) {
			instance = new Singleton03();
		}
		return instance;
	}
}