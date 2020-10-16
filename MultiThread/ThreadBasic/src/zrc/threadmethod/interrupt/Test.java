package zrc.threadmethod.interrupt;

public class Test {
    public static void main(String[] args) {
        SubThread8 subThread8 = new SubThread8();
        subThread8.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main thread--->" + i);
        }
        subThread8.interrupt(); // 仅仅是给子线程标记中断，子线程没有真正中断
    }
}
