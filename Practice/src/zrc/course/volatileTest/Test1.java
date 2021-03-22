package zrc.course.volatileTest;

// volatile保证可见性
// 对可见性的验证
public class Test1 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
            resource.add();
            System.out.println(Thread.currentThread().getName() + "\t updated number value:" + resource.value);
        }, "AAA").start();
        while (resource.value == 0) {}
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}

class Resource {
    int value = 0;

    public void add() {
        this.value = 60;
    }
}
