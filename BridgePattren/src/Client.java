
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoldedPhone foldedPhone = new FoldedPhone(new XiaoMi());
		foldedPhone.open();
		foldedPhone.close();
		foldedPhone.call();
	}

}
