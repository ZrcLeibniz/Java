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
		return "�����ʼ���Ϣ";
	}
}

class WeChat implements IReceiver{
	public String getInfo() {
		return "΢����Ϣ";
	}
}

interface IReceiver{
	public String getInfo();
}