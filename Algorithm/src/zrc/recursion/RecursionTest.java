package zrc.recursion;

public class RecursionTest {
	public static void main(String[] args) {
		test(4);
	}

	public static void test(int n) {
		if (n > 2) {
			test(n - 1);
		}
		System.out.println("n="+n);
	}
	
	public static int factorial(int n) {
		if(n == 1) {
			return n;
		}else {
			return n * factorial(n - 1); 
		}
	}
	
}
