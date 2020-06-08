package zrc.visitor;

import java.util.LinkedList;
import java.util.List;

public class ObjectStruct {
	private List<Person> persons = new LinkedList<Person>();

	public void attache(Person p) {
		persons.add(p);
	}

	public void detach(Person p) {
		persons.remove(p);
	}

	public void display(Action action) {
		for (Person p : persons) {
			p.accept(action);
		}
	}

}
