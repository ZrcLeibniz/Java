package zrc.comprisepattern;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

	List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

	public College(String name, String des) {
		super(name, des);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void print() {
		// TODO Auto-generated method stub
		System.out.println("--------" + this.getName() + "");
		for (OrganizationComponent organizationComponent : organizationComponents) {
			organizationComponent.print();
		}
	}

	@Override
	protected void add(OrganizationComponent organizationComponent) {
		// TODO Auto-generated method stub
		organizationComponents.add(organizationComponent);
	}

	@Override
	protected void remove(OrganizationComponent organizationComponent) {
		// TODO Auto-generated method stub
		organizationComponents.remove(organizationComponent);
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
