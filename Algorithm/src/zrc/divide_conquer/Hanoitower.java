package zrc.divide_conquer;

public class Hanoitower {
	public static void main(String[] args) {
		hanoiTower(64, 'A', 'B', 'C');
	}

	public static void hanoiTower(int num, char a, char b, char c) {
		if (num == 1) {
			System.out.println("��1���̴�" + a + "->" + c);
		} else {
			hanoiTower(num - 1, a, c, b);
			System.out.println("��" + num + "���̴�" + a + "->" + c);
			hanoiTower(num - 1, b, a, c);
		}
	}
}
