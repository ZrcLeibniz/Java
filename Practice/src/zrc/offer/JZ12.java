package zrc.offer;

public class JZ12 {
    public static double Power(double base, int exponent) {
        double result = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result  = result * base;
            }
            return result;
        } else if (exponent == 0) {
            return 1;
        } else {
            for (int i = 0; i < -exponent; i++) {
                result  = result * base;
            }
            return 1 / result;
        }
    }

    public static void main(String[] args) {
        double power = Power(2, -3);
        System.out.println(power);
    }
}
