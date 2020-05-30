package zrc.comprisepattern;

import java.util.ArrayList;
import java.util.List;

public class Departent extends OrganizationComponent {

	public Departent(String name, String des) {
		super(name, des);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void print() {
		// TODO Auto-generated method stub
		System.out.println("-----------"+this.getName()+"");
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public void setDes(String des) {
		// TODO Auto-generated method stub
		super.setDes(des);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	

}
