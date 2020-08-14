package zrc.zoom;

/*
使用递归求最大公约数
 */
public class CrackNuts08 {
    public static void main(String[] args) {

    }

    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return gcd(n, m % n);
    }
}
