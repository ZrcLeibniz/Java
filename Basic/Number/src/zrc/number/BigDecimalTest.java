package zrc.number;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(100);
        BigDecimal bigDecimal1 = new BigDecimal(200);
        BigDecimal add = bigDecimal.add(bigDecimal1);
        System.out.println(add);
    }
}
