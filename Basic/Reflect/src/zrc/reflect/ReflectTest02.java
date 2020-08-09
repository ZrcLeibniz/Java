package zrc.reflect;
/*
获取到Class对象可以做什么事
 */
public class ReflectTest02 {
    public static void main(String[] args) {
        try {
            Class c = Class.forName("zrc.reflect.bean.User");
            Object o = c.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
