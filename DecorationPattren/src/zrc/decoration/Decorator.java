package zrc.decoration;

public class Decorator extends Drink {
	private Drink obj;

	public Decorator(Drink drink) {
		// TODO Auto-generated constructor stub
		obj = drink;
	}

	@Override
	public float cost() {
		// TODO Auto-generated method stub
		return super.getPrice() + obj.cost();
	}

	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return super.des + " " + super.getPrice() + "&&" + obj.getDes();
	}
}
