package zrc;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        int num = b.getValue();
        System.out.println(num);
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
/*
* 第一步：要new一个B对象，所以会执行B()方法
* 第二步：在B()方法内部，首先会执行super(5)，super会指向其父类引用，所以会执行A()
* 第三步：在A()方法内部会执行setValue()方法，这里就会出现第一个迷惑的点setValue()方法到底是执行以下那个方法体中的内容
*       public void setValue(int value) {
*           super.setValue(2 * value);
*       }
*       public void setValue(int value) {
*           this.value = value;
*       }
*       千万牢记，java中的实例方法，必须有引用来调用，不能凭空出现，如果方法前没有引用调用，那么就是省略了this，所以到底执行那么方法
*       我们只需要搞清楚是this指向的是哪个对象，很显然，我们这个时候是在执行B对象的构造方法，所以this指针指向的肯定是B类型的对象，所以
*       执行的一定是上面列出的第一个setValue(int value)
* 第四步：在A()方法内部的setValue()方法会执行super.setValue(2 * value)，而super指向的是其父类，所以实际执行的方法还是A中的
*       setValue()，只不过参数已经被修改为10，所以此时value的值会被修改为10
* 第五步：这一步相对来说较为复杂：
*       (1)这个时候，我们需要执行的内容是setValue(getValue() - 3)，首先需要执行getValue() - 3来获取setValue()方法执行所需的参数
*       (2)在执行getValue()的时候，value的目前的值是10，会现对value的值进行自增操作，这时候value的值已经变为11，之后将value的值返回
*       (3)finally中的语句会在将value返回之后执行，所以说value的值会被修改为22，并且输出。
*       (4)但是要明确的是，java代码的执行顺序有如下规定：
*           - 代码必须从上到下执行
*           - return执行代表程序的结束
*           - finally中的语句不管有什么情况发生必须执行
*       为了满足这种要求，finally语句块中会将value的值修改为22，但是将11保存在栈帧中的局部变量表中，最终返回11这个值
*       (5)那么显然setValue()方法中的参数就是8了，我们执行setValue之后，value的值会从22更新为16，这个时候new B()这个操作就结束了
* 第六步：继续向下执行来到int num = b.getValue();此时这个对象的成员变量value的值是16，对value进行自增之后，value的值变为17，之后
*       将17返回，所以num的值就是17，（参考第五步的(4)，这一点在字节码中也有体现）finally语句中的代码会将value的值修改为34，并且将其打印。
* 最后一步：将num打印，所以大运的结果是22 34 17
*/