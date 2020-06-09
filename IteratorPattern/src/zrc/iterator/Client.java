package zrc.iterator;

import java.util.ArrayList;

public class Client {
	public static void main(String[] args) {
		ArrayList<College> collegeList = new ArrayList<>();
		ComputerCollege computerCollege = new ComputerCollege();
		InfoCollege infoCollege = new InfoCollege();
		collegeList.add(computerCollege);
		collegeList.add(infoCollege);
		OutPut outPut = new OutPut(collegeList);
		outPut.printCollege();
	}
}
