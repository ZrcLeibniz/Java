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
		System.out.println("��һ����ѡ�����ʵĻƶ�");
	}

	abstract void addCondiments();

	void soak() {
		System.out.println("�ݶ���");
	}

	void beat() {
		System.out.println("�򶹽�");
	}

	boolean customerWant() {
		return true;
	}
}
