package zrc.threadmethod.setpriority;

public class Test {
    public static void main(String[] args) {
        SubThread6 subThread6 = new SubThread6();
        SubThread7 subThread7 = new SubThread7();
        subThread6.setPriority(1);
        subThread6.start();
        subThread7.setPriority(10);
        subThread7.start();
    }
}
