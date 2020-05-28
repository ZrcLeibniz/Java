package sheep;

public class SheepPlus implements Cloneable{
	private String name;
	private int age;
	private String color;

	public SheepPlus(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "SheepPlus [name=" + name + ", age=" + age + ", color=" + color + "]";
	}
	
	@Override
	public SheepPlus clone(){
		// TODO Auto-generated method stub
		SheepPlus sheep = null;
		try {
			sheep = (SheepPlus)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return sheep;
	}

}
