public class TestClass01 {
    /*
     * 在类的内部又定义了一个类，成为内部类
     * 内部类分为：静态内部类 实例内部类、局部内部类
     */

    static class inner1 {
    }

    class inner2 {
    }

    public void doSome() {
        class inner3 {
        }
    }

    public static void main(String[] args) {
        MyMath myMath = new MyMath();
        myMath.sum(new Compute(){
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        }, 100, 200);
    }
}

/*
class ComputeImpl implements Compute{
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
*/
interface Compute{
    int sum(int a, int b);
}

class MyMath{
    public void sum(Compute c, int x, int y){
        int value = c.sum(x, y);
        System.out.println(value);
    }
}