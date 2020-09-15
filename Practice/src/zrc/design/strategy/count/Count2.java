package zrc.design.strategy.count;

import java.util.Scanner;

public class Count2 {
    public double count(int number, double price) {
        System.out.println("请输入收费方式");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        double count = 0;
        switch (method) {
            case "正常收费":
                count = number * price;
                break;
            case "打五折":
                count = number * price * 0.5;
                break;
            case "打七折":
                count = number * price * 0.7;
                break;
            case "打八折":
                count = number * price * 0.8;
                break;
        }
        return count;
    }
}
