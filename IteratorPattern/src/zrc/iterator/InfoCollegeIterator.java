package zrc.iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator{

	List<Department> departmentList;
	int index = -1;
	
	
	public InfoCollegeIterator(List<Department> departmentList) {
		super();
		this.departmentList = departmentList;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index >= departmentList.size() - 1) {
			return false;
		}else {
			index += 1;
			return true;
		}
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return departmentList.get(index);
	}

}