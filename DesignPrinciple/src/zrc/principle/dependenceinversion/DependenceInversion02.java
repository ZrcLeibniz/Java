package zrc.principle.dependenceinversion;

public class DependenceInversion02 {
	public static void main(String[] args) {
		PersonPlus person = new PersonPlus();
		person.receive(new EmailPlus());
		person.receive(new WeChat());
	}
}

class PersonPlus{
	public void receive(IReceiver reciver) {
		System.out.println(reciver.getInfo());
	}
}

class EmailPlus implements IReceiver{
	public String getInfo() {
		return "电子邮件信息";
	}
}

class WeChat implements IReceiver{
	public String getInfo() {
		return "微信消息";
	}
}

interface IReceiver{
	public String getInfo();
}