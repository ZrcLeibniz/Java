package zrc.course.bite.bookmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }

    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的姓名");
        String name = scanner.next();
        System.out.println("请输入您的角色 1:管理员 2:普通用户");
        int who = scanner.nextInt();
        return who == 1 ? new Admin(name) : new NormalUser(name);
    }
}
