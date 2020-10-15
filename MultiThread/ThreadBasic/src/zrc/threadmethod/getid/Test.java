package zrc.threadmethod.getid;

public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId());
        for (int i = 1; i < 5; i++) {
            SubThread5 subThread5 = new SubThread5();
            subThread5.start();
        }
    }
}
