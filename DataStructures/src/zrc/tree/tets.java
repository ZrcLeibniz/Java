package zrc.tree;

public class tets {

}

class Peopel{
	private String name;
	private int age;
	public Peopel(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}

class Student extends Peopel{ 
	private String id;
	
	public Student(String name, int age, String id) {
		super(name, age);
		this.id = id;
	}

	
	
}