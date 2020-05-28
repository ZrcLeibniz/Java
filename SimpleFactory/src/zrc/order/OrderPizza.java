package zrc.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import zrc.pizza.CheesePizza;
import zrc.pizza.GreekPizza;
import zrc.pizza.Pizza;

public class OrderPizza {
//	public OrderPizza() {
//		Pizza pizza = null;
//		String orderType = null;
//		do {
//			orderType = getType();
//			if (orderType.equals("greek")) {
//				pizza = new GreekPizza();
//			} else if (orderType.equals("cheese")) {
//				pizza = new CheesePizza();
//			} else {
//				break;
//			}
//			pizza.setName(orderType);
//			pizza.bake();
//			pizza.cut();
//			pizza.box();
//		} while (true);
//	}
	
	public OrderPizza(SimpleFactory factory) {
		setFactory(factory);
	}
	
	SimpleFactory factory;
	Pizza pizza = null;
	public void setFactory(SimpleFactory factory) {
		String orderType = "";
		this.factory = factory;
		do {
			orderType = getType();
			pizza = this.factory.createPizza(orderType);
			if(pizza != null) {
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.cut();
			}else {
				System.out.println("");
			}
		}while(true);
	}

	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Input pizza type:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
}
