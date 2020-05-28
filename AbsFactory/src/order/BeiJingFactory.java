package order;

import pizza.BeiJingCheesePizza;
import pizza.BeiJingPepperPizza;
import pizza.Pizza;

public class BeiJingFactory implements AbsFactory{

	@Override
	public Pizza createPizza(String orderType) {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new BeiJingCheesePizza();
		}else if(orderType.equals("pepper")) {
			pizza = new BeiJingPepperPizza();
		}
		return pizza;
	}

}
