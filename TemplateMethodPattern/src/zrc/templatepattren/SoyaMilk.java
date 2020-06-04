package zrc.templatepattren;

public abstract class SoyaMilk {
	final void make() {
		selct();
		if (customerWant()) {
			addCondiments();
		}
		soak();
		beat();
	}

	void selct() {
		System.out.println("第一步：选择新鲜的黄豆");
	}

	abstract void addCondiments();

	void soak() {
		System.out.println("泡豆子");
	}

	void beat() {
		System.out.println("打豆浆");
	}

	boolean customerWant() {
		return true;
	}
}
