package zrc.iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator{
	
	Department[] departments;
	int position = 0;
	
	public ComputerCollegeIterator(Department[] departments) {
		super();
		this.departments = departments;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(position >= departments.length || departments[position] == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Department departent = departments[position];
		position += 1;
		return departent;
	}

}
