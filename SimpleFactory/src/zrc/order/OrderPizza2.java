package zrc.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import zrc.pizza.Pizza;

public class OrderPizza2 {
	Pizza pizza = null;
	String orderType = "";
	public OrderPizza2() {
		do {
			orderType = getType();
			pizza = SimpleFactory.createPizza2(orderType);
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
