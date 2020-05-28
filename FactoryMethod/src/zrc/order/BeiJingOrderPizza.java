package zrc.order;

import zrc.pizza.BeiJingCheesePizza;
import zrc.pizza.BeiJingPepperPizza;
import zrc.pizza.Pizza;

public class BeiJingOrderPizza extends OrderPizza {

	@Override
	Pizza createPizza(String orderType) {
		// TODO Auto-generated method stub
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new BeiJingCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new BeiJingPepperPizza();
		}
		return pizza;
	}
}
