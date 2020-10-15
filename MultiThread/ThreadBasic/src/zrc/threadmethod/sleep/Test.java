package zrc.threadmethod.sleep;

public class Test {
    public static void main(String[] args) {
        SubThread4 subThread4 = new SubThread4();
        System.out.println("main_begin:" + System.currentTimeMillis());
        subThread4.start();
        System.out.println("main_end:" + System.currentTimeMillis());
    }
}
