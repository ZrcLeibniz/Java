package zrc.principle.liskov;

public class Liskov02 {
	public static void main(String[] args) {
		aPlus a = new aPlus();
		System.out.println("11-3=" + a.func1(11, 3));
		System.out.println("1-8=" + a.func1(1, 8));
		System.out.println("---------------------------");
		bPlus b = new bPlus();
		System.out.println("11+3=" + b.func1(11, 3));
		System.out.println("1+8=" + b.func1(1, 8));
		System.out.println("11+3+9=" + b.func2(11, 3));
		System.out.println("11-3="+b.func3(11, 3));
	}
}
class Base {
	public int func1(int num1, int num2) {
		return num1 - num2;
	}
}
class aPlus extends Base {
	public int func1(int num1, int num2) {
		return num1 - num2;
	}
}
class bPlus extends Base {
	private aPlus aplus = new aPlus();

	public int func1(int a, int b) {
		return a + b;
	}
	public int func2(int a, int b) {
		return func1(a, b) + 9;
	}
	public int func3(int a, int b) {
		return aplus.func1(a, b);
	}
}