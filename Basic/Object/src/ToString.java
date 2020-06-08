public class ToString {
    private int test1;
    private int test2;

    @Override
    public String toString() {
        return "ToString{" +
                "test1=" + test1 +
                ", test2=" + test2 +
                '}';
    }

    public static void main(String[] args) {
        /*
        作用在于可以讲将一个Java对象转换为字符串的表示形式
         */
        ToString toString = new ToString();
        System.out.println(toString);
    }
}
