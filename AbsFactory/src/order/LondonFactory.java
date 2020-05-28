package order;

import pizza.LondonCheesePizza;
import pizza.LondonPepperPizza;
import pizza.Pizza;

public class LondonFactory implements AbsFactory{

	@Override
		public Pizza createPizza(String orderType) {
			// TODO Auto-generated method stub
			Pizza pizza = null;
			if (orderType.equals("cheese")) {
				pizza = new LondonCheesePizza();
			}else if(orderType.equals("pepper")) {
				pizza = new LondonPepperPizza();
			}
			return pizza;
		}
	}

