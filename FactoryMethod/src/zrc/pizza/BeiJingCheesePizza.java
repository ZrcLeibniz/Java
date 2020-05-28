package zrc.pizza;

public class BeiJingCheesePizza extends Pizza{

	@Override
	public void prepare() {
		setName("北京奶酪比萨");
		System.out.println("给北京奶酪比萨的制作准备原材料");
	}
	
}
