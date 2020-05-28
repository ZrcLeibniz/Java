package client;

import Absbuilder.CommonHouse;
import Absbuilder.HouseDirector;
import house.AbstractHouse;

public class Client {
	public static void main(String[] args) {
		CommonHouse commonHouse = new CommonHouse();
		HouseDirector houseDirector = new HouseDirector(commonHouse);
		AbstractHouse constructHouse = houseDirector.constructHouse();
	}
}
