package zrc.number;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        /*
        # 代表任意数字
        , 代表千分位
        . 代表小数点
        0 代笔不够时补零
         */
        DecimalFormat decimalFormat = new DecimalFormat("###,###.000000");
        String format = decimalFormat.format(1234.56);
        System.out.println(format);
    }
}
