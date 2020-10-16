package zrc.threadmethod.setpriority;

public class SubThread6 extends Thread {
    @Override
    public void run() {
        // 设置线程的优先级，java线程的优先级的取值范围是1-10
        // 如果超出此范围会抛出异常ILLegalArgumentException
        // 线程优先级本质上只是给线程调度器一个提示信息，以便于调度器决定先调用哪些线程
        // 注意:不能保证优先级高的线程先运行
        // 线程的优先级具有继承性，在A线程中创建了B线程，则B线程的优先级与A线程是一样的
        // 线程优先级的默认值是5
        long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i <= 1000000000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("SubThread6:" + (end - begin));
    }
}
