package zrc.decoration;

public class Milk extends Decorator{

	public Milk(Drink drink) {
		super(drink);
		setDes("еёдл");
		setPrice(2.0f);
	}

}
