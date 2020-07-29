package zrc.test.tree;

import zrc.tree.UF;

import java.util.Scanner;

public class UFTest {
    public static void main(String[] args) {
        UF uf = new UF(5);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入第一个合并的元素");
            int next = scanner.nextInt();
            System.out.println("请输入第二个合并的元素");
            int next2 = scanner.nextInt();
            if (uf.connected(next, next2)) {
                System.out.println("已在同一组");
                continue;
            } else {
                uf.union(next, next2);
                System.out.println(uf.getCount());
            }
        }
    }
}
