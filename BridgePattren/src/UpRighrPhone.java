
public class UpRighrPhone extends Phone{

	public UpRighrPhone(Brand brand) {
		super(brand);
		// TODO Auto-generated constructor stub
	}
	
	public void open() {
		super.open();
		System.out.println("ֱ��");
	}
	
	public void close() {
		super.close();
		System.out.println("ֱ��");
	}
	
	public void call() {
		super.call();		
		System.out.println("ֱ��");
	}

}
