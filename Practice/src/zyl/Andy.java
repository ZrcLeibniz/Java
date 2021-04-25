package zyl;

import java.util.Scanner;

public class Andy {
    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int qwe(int q, int e) {
        int t = q - e;
        return t;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入第一个数字");
            int a1 = scanner.nextInt();
            System.out.println("请输入第二个数字");
            int a2 = scanner.nextInt();
//            int add = add(a1, a2);
            int qwe = qwe(a1, a2);
            System.out.println("结果是：" + qwe);
        }
    }

    private int value;
    public int getValue() {
        try {
            value++;
            return value;
        } finally {
            this.setValue(value);
            System.out.println(value);
        }
    }

    public void setValue(int value) {
        this.value = value;
    }
}
