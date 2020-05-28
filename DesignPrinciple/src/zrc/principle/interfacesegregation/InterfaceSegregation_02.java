package zrc.principle.interfacesegregation;

public class InterfaceSegregation_02 {
	public static void main(String[] args) {
		A a = new A();
		a.depend1(new B());
		a.depend2(new B());
		a.depend3(new B());
		
		C c = new C();
		c.depend1(new D());
		c.depend4(new D());
		c.depend5(new D());
	}
}

interface InterfacePlus_01 {
	void operation1();
}

interface InterfacePlus_02 {
	void operation2();

	void operation3();
}

interface InterfacePlus_03 {
	void operation4();

	void operation5();
}

class B_plus implements InterfacePlus_01, InterfacePlus_02 {

	@Override
	public void operation1() {
		// TODO Auto-generated method stub
		System.out.println("B实现了operation1");
	}

	@Override
	public void operation2() {
		// TODO Auto-generated method stub
		System.out.println("B实现了operation2");
	}

	@Override
	public void operation3() {
		// TODO Auto-generated method stub
		System.out.println("B实现了operation3");
	}
}

class D_plus implements InterfacePlus_01, InterfacePlus_03 {

	@Override
	public void operation1() {
		// TODO Auto-generated method stub
		System.out.println("D实现了operation1");
	}

	@Override
	public void operation4() {
		// TODO Auto-generated method stub
		System.out.println("D实现了operation4");
	}

	@Override
	public void operation5() {
		// TODO Auto-generated method stub
		System.out.println("D实现了operation5");
	}

}

class A_plus {
	public void depend1(InterfacePlus_01 i) {
		i.operation1();
	}

	public void depend2(InterfacePlus_02 i) {
		i.operation2();
	}

	public void depend3(InterfacePlus_02 i) {
		i.operation3();
	}
}

class C_plus {
	public void depend1(InterfacePlus_01 i) {
		i.operation1();
	}

	public void depend4(InterfacePlus_03 i) {
		i.operation4();
	}

	public void depend5(InterfacePlus_03 i) {
		i.operation5();
	}
}