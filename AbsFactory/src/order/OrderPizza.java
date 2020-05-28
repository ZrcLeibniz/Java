package order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pizza.Pizza;

public class OrderPizza {
	AbsFactory Factory;
	private void setFactory(AbsFactory factory) {
		Pizza pizza = null;
		String orderType = "";
		this.Factory = factory;
		do {
			orderType = getType();
			pizza = factory.createPizza(orderType);
			if(pizza != null) {
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			}else {
				System.out.println("¶©¹ºÊ§°Ü");
				break;
			}
		}while(true);
	}
	
	public OrderPizza(AbsFactory factory) {
		setFactory(factory);
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
