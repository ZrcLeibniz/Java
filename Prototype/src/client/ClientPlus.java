package client;

import sheep.SheepPlus;

public class ClientPlus {
	public static void main(String[] args) {
		SheepPlus sheep = new SheepPlus("tom", 10, "white");
		SheepPlus clone = sheep.clone();
		System.out.println(clone);
	}
}
