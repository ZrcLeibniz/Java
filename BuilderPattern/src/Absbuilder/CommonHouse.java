package Absbuilder;

public class CommonHouse extends Builder{

	@Override
	public void buildBasic() {
		// TODO Auto-generated method stub
		System.out.println("给高房子打10米地基");
		
	}

	@Override
	public void buildWalls() {
		// TODO Auto-generated method stub
		System.out.println("给高房子砌100米墙");
	}

	@Override
	public void buildRoffed() {
		// TODO Auto-generated method stub
		System.out.println("给高房子封顶");
	}
	
}
