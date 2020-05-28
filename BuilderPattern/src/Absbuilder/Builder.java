package Absbuilder;

import house.AbstractHouse;

public abstract class Builder {
	protected AbstractHouse house = new AbstractHouse();

	public abstract void buildBasic();

	public abstract void buildWalls();

	public abstract void buildRoffed();
	
	public AbstractHouse buildHouse() {
		return house;
	}
}
