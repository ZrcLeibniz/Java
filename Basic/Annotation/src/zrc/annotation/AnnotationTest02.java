package zrc.annotation;
/*
关于JDK lang包下的@Override注解
 */
public class AnnotationTest02 {
    String name;

    public static void main(String[] args) {

    }
// 该注解只能注解方法，并且是给编译器参考的和运行阶段没有关系
// 凡是java中的方法带有这个注解的，编译器都会进行编译检查，如果不是重写父类的方法，编译器报错
    @Override
    public String toString() {
        return "AnnotationTest02{" +
                "name='" + name + '\'' +
                '}';
    }
}
