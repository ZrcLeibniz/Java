// 这是一个无限循环的注册登录

package zrc.course.bite;

import java.util.HashMap;
import java.util.Scanner;

public class Homework_20210125_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();
        while (true) {
            System.out.println("欢迎进入程序");
            int menu = loginService.menu();
            if (menu == 3) {
                break;
            } else if (menu == 2) {
                System.out.println("请输入用户名");
                String name = scanner.next();
                System.out.println("请输入密码");
                String password = scanner.next();
                try {
                    loginService.login(name, password);
                } catch (LoginException e) {
                    e.printStackTrace();
                }
            } else if (menu == 1) {
                System.out.println("请输入用户名");
                String name = scanner.next();
                System.out.println("请输入密码");
                String password = scanner.next();
                loginService.addUser(name, password);
            }
        }
    }
}

class LoginException extends Exception {
    public LoginException(String message) {
        super(message);
    }
}

class LoginService {
    private UserInfo userInfo = new UserInfo();

    public void login(String userName, String password) throws LoginException {
        if (userInfo.getUserNum() == 0) {
            throw new LoginException("当前用户信息表中没有用户请注册");
        } else {
           if (userInfo.isValidLogin(userName, password)) {
               System.out.println("登录成功");
           } else {
               throw new LoginException("用户名或密码错误");
           }
        }
    }

    public int menu() {
        System.out.println("注册账号：1");
        System.out.println("登录：2");
        System.out.println("退出：3");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    public void addUser(String name, String password) {
        userInfo.addUser(new User(name, password));
    }
}

class UserInfo {
    private HashMap<String, String> userTable = new HashMap<>();

    public void addUser(User user) {
        userTable.put(user.userName, user.password);
    }

    public int getUserNum() {
        return userTable.size();
    }

    public boolean isValidLogin(String username, String password) {
        if (userTable.containsKey(username)) {
            if (userTable.get(username).equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

class User {
    String userName;
    String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
