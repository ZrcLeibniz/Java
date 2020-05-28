package Absbuilder;

import house.AbstractHouse;

public class HouseDirector {
	Builder builder = null;

	public HouseDirector(Builder builder) {
		super();
		this.builder = builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public AbstractHouse constructHouse() {
		builder.buildBasic();
		builder.buildWalls();
		builder.buildRoffed();
		return builder.buildHouse();
	}
}
