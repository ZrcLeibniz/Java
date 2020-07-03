package zrc.exception;

public class ExceptionTest02 {
    public static void main(String[] args) throws ClassNotFoundException {
        doSome();
        try {
            doSome2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void doSome() throws ClassNotFoundException {
        System.out.println("DOSOME!!!");
    }

    public static void doSome2() throws Exception {
        System.out.println("DOSOME!!!");
    }
}
