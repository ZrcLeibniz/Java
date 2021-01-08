package rich.zrc.monitor;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
成员变量和静态变量是否线程安全
    ·如果他们没有被共享则线程安全
    ·如果他们被共享了，根据它们的状况是否能改变又分为两种情况
        ·如果只有读操作，则线程安全
        ·如果需要读写操作1，则这段代码1是临界区，需要考虑线程安全问题

局部变量是否线程安全
    ·局部变量是线程安全的
    ·局部变量引用的对象未必是安全的
        ·如果该对象没有逃离方法的作用访问，它是线程安全的
        ·如果该对象逃离方法的作用范围，需要考虑线程安全
 */
public class Test5 {
    static final int Thread_Number = 2;
    static final int Loop_Number = 200;

    public static void main(String[] args) {
        ThreadUnSafe threadUnSafe = new ThreadUnSafe();
        for (int i = 0; i < Thread_Number; i++) {
            new Thread(() -> {
                threadUnSafe.method1(200);
            }, "Thread" + (i + 1)).start();
        }
    }


}

class ThreadUnSafe {
    public void method1(int loopNumber) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            method2(list);
            method3(list);
        }
    }

    private void method3(ArrayList<Integer> list) {
        list.remove(0);
    }

    private void method2(ArrayList<Integer> list) {
        list.add(1);
    }
}

class ThreadSafe {
    ArrayList<Integer> list = new ArrayList<>();

    public void method1(int loopNumber) {
        for (int i = 0; i < loopNumber; i++) {
            method2();
            method3();
        }
    }

    private void method3() {
        list.remove(0);
    }

    private void method2() {
        list.add(1);
    }
}