package zrc.course.bite;

import java.util.Scanner;

public class Homework_20201214_5 {
    public static void main(String[] args) {
        int count = 3;
        Scanner scanner = new Scanner(System.in);
        Homework_20201214_5 test = new Homework_20201214_5();
        while (count > 0) {
            System.out.println("请输入密码：");
            String input = scanner.next();
            if (test.isValid(input)) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("密码错误，请重新输入");
                count--;
            }
        }
        System.out.println("输入失败");
    }

    public boolean isValid(String input) {
        String password = "rich";
        if (input.equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
