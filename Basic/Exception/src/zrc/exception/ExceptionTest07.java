package zrc.exception;

public class ExceptionTest07 {
    public static void main(String[] args) {
        MyException myException = new MyException("用户名不能为空");
        myException.printStackTrace();
        System.out.println(myException.getMessage());
    }
}

class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}


