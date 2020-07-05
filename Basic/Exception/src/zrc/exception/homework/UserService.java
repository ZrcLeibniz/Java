package zrc.exception.homework;

public class UserService {
    public void register(String username, String password) throws IllegalArgsException {
        if (null == username || username.length() < 6 || username.length() > 14) {
            throw new IllegalArgsException("用户名不合理");
        }
        System.out.println("注册成功， 欢迎" + username);
    }
}
