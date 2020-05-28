package zrc.order;

import zrc.pizza.CheesePizza;
import zrc.pizza.GreekPizza;
import zrc.pizza.PepperPizza;
import zrc.pizza.Pizza;

public class SimpleFactory {
	public Pizza createPizza(String orderType) {
		Pizza pizza = null;
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(orderType);
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(orderType);
		}else if(orderType.equals("Pepper")) {
			pizza = new PepperPizza();
			pizza.setName(orderType);
		}
		return  pizza;
	}
	
	public static Pizza createPizza2(String orderType) {
		Pizza pizza = null;
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(orderType);
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName(orderType);
		}else if(orderType.equals("Pepper")) {
			pizza = new PepperPizza();
			pizza.setName(orderType);
		}
		return  pizza;
	}
}
