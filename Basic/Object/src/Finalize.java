public class Finalize {
    public static void main(String[] args) {
        /*
         * finalize方法是protected修饰的，并且没有方法体。此方法不需要程序员手动调用。JVM的垃圾回收器会自动调用
         * 当一个Java对象即将被垃圾回收时，垃圾回收器负责调用此方法
         * finalize方法实际上是SUN公司为Java程序员准备的一个时机，如果希望在对象销毁时执行一段代码，这段代码就写
         * 在此方法中
         */
        Person person = new Person();
        person = null;
        System.gc(); // 建议启动垃圾回收器，但是不一定听不听话
        /*
         * 该方法不一定立即调用，因为垃圾回收器不一定会立即启动
         */
    }
}

class Person{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("即将被销毁");
    }
}