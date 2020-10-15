package zrc.threadmethod.isalive;

public class Test {
    public static void main(String[] args) {
        SubThread3 subThread3 = new SubThread3();
        System.out.println("begin==" + subThread3.isAlive());
        subThread3.start();
        System.out.println("end==" + subThread3.isAlive());
    }
}
