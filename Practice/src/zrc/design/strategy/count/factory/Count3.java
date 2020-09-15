package zrc.design.strategy.count.factory;

import java.util.Scanner;

public class Count3 {
    public double count(int number, double price) {
        System.out.println("请输入收费方式");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        CashFactory cashFactory = new CashFactory();
        CashSuper cashObj = cashFactory.create(s);
        double v = cashObj.acceptCash(number * price);
        return v;
    }
}
