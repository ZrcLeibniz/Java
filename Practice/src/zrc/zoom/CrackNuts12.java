package zrc.zoom;
/*
汉诺塔问题
 */

public class CrackNuts12 {
    public static void printHanoiTower(int N, String from, String to, String help) {
        if (N == 1) {
            System.out.println("move" + N + "from" + from + "to" + to);
            return;
        }
        printHanoiTower(N - 1, from, help, to);
        System.out.println("move" + N + "from" + from + "to" + to);
        printHanoiTower(N - 1, help, to, from);
    }
}
