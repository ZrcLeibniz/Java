package zrc.principle.dependenceinversion;

public class DependenceInversion01 {
	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
	}
}

// �����ȡ�Ķ������ʼ����Ƕ���֮��ģ�Ҫ������Щ��Ϣ������Ҫ������Щ�࣬Person��ҲҪ������Ӧ����
// ���˼·������һ������Ľӿ�IReceiver����ʾ�����ߣ�����Person����ӿڷ�������

class Person{
	public void receive(Email email) {
		System.out.println(email.getInfo());
	}
}

class Email{
	public String getInfo() {
		return "�����ʼ���Ϣ";
	}
}