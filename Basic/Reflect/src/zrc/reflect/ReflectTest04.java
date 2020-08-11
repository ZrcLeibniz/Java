package zrc.reflect;

public class ReflectTest04 {
    public static void main(String[] args) {
        // 只要文件在类路径下，就可以获取这个文件的绝对路径
        String path = Thread.currentThread().getContextClassLoader().getResource("classinfo.properties").getPath();
        System.out.println(path);
    }
}
