package zrc.simulate;

import java.util.ResourceBundle;

public class JavaProgrammer {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String className = bundle.getString("className");
        try {
            Class c = Class.forName(className);
            JDBC jdbc = (JDBC)c.newInstance();
            jdbc.generation();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
