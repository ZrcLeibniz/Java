package zrc.reflect;

import java.util.ResourceBundle;

/*
java.util包下提供了一个资源绑定器，便于获取属性配置文件中的内容
使用这种方式的时候，属性配置文件必须放到类路径下
 */
public class ResourceBundleTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("classinfo");
        String className = resourceBundle.getString("className");
        Class.forName(className);
    }
}
