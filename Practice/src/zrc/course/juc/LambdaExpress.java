package zrc.course.juc;

@FunctionalInterface
interface Foo {
    int add(int x, int y);
    /*
    在java8之前，接口中只能有方法的声明，不能有方法的实现
    java8及以后，可以使用default关键字
    静态方法实现
     */

    default int div(int x, int y) {
        return x / y;
    }

    static int mav(int x, int y) {
        return x * y;
    }
}

public class LambdaExpress {
    public static void main(String[] args) {
        Foo foo = (x, y) -> {
          return x + y;
        };
        int add = foo.add(1, 1);
        System.out.println(add);

        foo.div(10, 5);
    }
}
