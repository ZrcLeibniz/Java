package zrc.visitor;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectStruct objectStruct = new ObjectStruct();
		objectStruct.attache(new Man());
		objectStruct.attache(new Man());
		objectStruct.attache(new Woman());
		objectStruct.attache(new Woman());
		Success success = new Success();
		objectStruct.display(success);
	}

}
