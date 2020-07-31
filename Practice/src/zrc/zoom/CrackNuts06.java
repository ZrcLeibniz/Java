package zrc.zoom;

/*
给定一个介于0和1之间的实数，类型为double，打印它的二进制表示
 */
public class CrackNuts06 {
    public static void main(String[] args) {
        double num = 0.625;
        StringBuilder stringBuilder = new StringBuilder("0.");
        while (num > 0) {
            double temp = num * 2;
            if (temp >= 1) {
                stringBuilder.append("1");
                num = temp - 1;
            } else {
                stringBuilder.append("0");
                num = temp;
            }
            if (stringBuilder.length() > 34) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println(stringBuilder);
    }
}
