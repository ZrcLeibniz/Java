package zrc.exception.homework;

public class Test {
    public static void main(String[] args) {
        UserService userService = new UserService();
        try {
            userService.register("jackson", "123");
        } catch (IllegalArgsException e) {
            e.printStackTrace();
        }
    }
}
