package zrc.design.strategy;

import zrc.design.strategy.count.Count1;
import zrc.design.strategy.count.Count2;
import zrc.design.strategy.count.factory.Count3;

import java.util.Scanner;

public class countMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品个数");
        int number = scanner.nextInt();
        System.out.println("请输入商品单价");
        double price = scanner.nextDouble();
        Count3 count3 = new Count3();
        double count = count3.count(number, price);
        System.out.println("商品总价为: "+count);
    }
}
