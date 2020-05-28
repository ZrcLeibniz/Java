package zrc.creatingpattern.singleton;

public class Singleton_08 {

	public static void main(String[] args) {
		Singleton08 instance = Singleton08.INSTANCE;
		Singleton08 instance2 = Singleton08.INSTANCE;
		System.out.println(instance == instance2);
		instance.sayOk();
	}

}

enum Singleton08{
	INSTANCE;
	public void sayOk() {
		System.out.println("ok");
	}
}