package zrc.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import zrc.pizza.Pizza;

public abstract class OrderPizza {
	abstract Pizza createPizza(String orderType);
	
	public OrderPizza() {
		Pizza pizza = null;
		String orderType = null;
		do {
			orderType = getType();
			pizza = createPizza(orderType);
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		} while (true);
	}
	
//	public OrderPizza(SimpleFactory factory) {
//		setFactory(factory);
//	}
	
//	Pizza pizza = null;
//	public void setFactory(SimpleFactory factory) {
//		String orderType = "";
//		this.factory = factory;
//		do {
//			orderType = getType();
//			pizza = this.factory.createPizza(orderType);
//			if(pizza != null) {
//				pizza.prepare();
//				pizza.bake();
//				pizza.cut();
//				pizza.cut();
//			}else {
//				System.out.println("");
//			}
//		}while(true);
//	}

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
