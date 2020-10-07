package rich.zrc;

public class HelloMaven {
    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        int add = helloMaven.add(1, 2);
        System.out.println(add);
    }

    public int add(int n1, int n2) {
        return n1 + n2;
    }
}
