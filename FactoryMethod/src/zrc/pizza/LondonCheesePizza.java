package zrc.pizza;

public class LondonCheesePizza extends Pizza{

	@Override
	public void prepare() {
		setName("伦敦奶酪比萨");
		System.out.println("给伦敦奶酪比萨的制作准备原材料");
	}
	
}
