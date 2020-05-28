package Absbuilder;

public class HighHouse extends Builder{

	@Override
	public void buildBasic() {
		// TODO Auto-generated method stub
		System.out.println("给普通房子打5米地基");
		
	}

	@Override
	public void buildWalls() {
		// TODO Auto-generated method stub
		System.out.println("给普通房子砌10米墙");
	}

	@Override
	public void buildRoffed() {
		// TODO Auto-generated method stub
		System.out.println("给普通房子封顶");
	}
	
}
