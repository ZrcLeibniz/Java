package zrc.zoom;

/*
将一个整数的奇数位和偶数位互换
 */
public class CrackNuts05 {
    public static void main(String[] args) {
        int a = 120;
        int b = m(a);
        System.out.println(b);
    }

    private static int m(int i) {
        int ou = i & 0b10101010101010101010101010101010;
        int ji = i & 0b01010101010101010101010101010101;
        return (ou >> 1) ^ (ji << 1);
    }
}
