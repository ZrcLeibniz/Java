package zrc.lenum;

public class EnumTest {
    public static void main(String[] args) {
        Result divide = divide(10, 0);
        System.out.println(divide);
    }

    public static Result divide(int a, int b) {
        try {
            int c = a / b;
            return Result.SUCCESS;
        } catch (Exception e) {
            return Result.FAIL;
        }
    }
}

enum Result {
    SUCCESS,
    FAIL
}
