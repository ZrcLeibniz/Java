package zrc.decoration;

public class Client {
	public static void main(String[] args) {
		Drink order = new LongBlackCoffee();
		System.out.println(order.cost());
		System.out.println(order.getDes());
		order = new Milk(order);
		System.out.println(order.cost());
		System.out.println(order.getDes());
		order = new Chocolate(order);
		System.out.println(order.cost());
		System.out.println(order.getDes());
		System.out.println(order.cost());
		System.out.println(order.getDes());
	}
}
