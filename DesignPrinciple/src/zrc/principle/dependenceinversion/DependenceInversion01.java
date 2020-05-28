package zrc.principle.dependenceinversion;

public class DependenceInversion01 {
	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
	}
}

// 如果获取的对象不是邮件而是短信之类的，要接受这些消息，就需要新增这些类，Person类也要新增相应方法
// 解决思路：引入一个抽象的接口IReceiver，表示接收者，这样Person类与接口发生依赖

class Person{
	public void receive(Email email) {
		System.out.println(email.getInfo());
	}
}

class Email{
	public String getInfo() {
		return "电子邮件信息";
	}
}