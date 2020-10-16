package zrc.threadmethod.interrupt;

public class Tes2 {
    public static void main(String[] args) {
        SubThread9 subThread9 = new SubThread9();
        subThread9.start();
        for (int i = 0; i <= 100; i++) {
            System.out.println("main thread--->" + i);
        }
        subThread9.interrupt(); // 仅仅是给子线程标记中断，子线程没有真正中断
    }
}
