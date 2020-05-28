package order;

import pizza.Pizza;

public interface AbsFactory {
	public Pizza createPizza(String orderType);
}
