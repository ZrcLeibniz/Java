package zrc.principle.interfacesegregation;

public class InterfaceSegregation_01 {
	public static void main(String[] args) {
		
	}
}

interface Interface1 {
	void operation1();

	void operation2();

	void operation3();

	void operation4();

	void operation5();
}

class B implements Interface1 {

	@Override
	public void operation1() {
		// TODO Auto-generated method stub
		System.out.println("Bʵ����operation1");
	}

	@Override
	public void operation2() {
		// TODO Auto-generated method stub
		System.out.println("Bʵ����operation2");
	}

	@Override
	public void operation3() {
		// TODO Auto-generated method stub
		System.out.println("Bʵ����operation3");
	}

	@Override
	public void operation4() {
		// TODO Auto-generated method stub
		System.out.println("Bʵ����operation4");
	}

	@Override
	public void operation5() {
		// TODO Auto-generated method stub
		System.out.println("Bʵ����operation5");
	}

}

class D implements Interface1 {

	@Override
	public void operation1() {
		// TODO Auto-generated method stub
		System.out.println("Dʵ����operation1");
	}

	@Override
	public void operation2() {
		// TODO Auto-generated method stub
		System.out.println("Dʵ����operation2");
	}

	@Override
	public void operation3() {
		// TODO Auto-generated method stub
		System.out.println("Dʵ����operation3");
	}

	@Override
	public void operation4() {
		// TODO Auto-generated method stub
		System.out.println("Dʵ����operation4");
	}

	@Override
	public void operation5() {
		// TODO Auto-generated method stub
		System.out.println("Dʵ����operation5");
	}

}

class A {
	public void depend1(Interface1 i) {
		i.operation1();
	}

	public void depend2(Interface1 i) {
		i.operation2();
	}

	public void depend3(Interface1 i) {
		i.operation3();
	}
}

class C {
	public void depend1(Interface1 i) {
		i.operation1();
	}

	public void depend4(Interface1 i) {
		i.operation4();
	}

	public void depend5(Interface1 i) {
		i.operation5();
	}
}