import java.util.Objects;

public class Equals {
    private int test1;
    private int test2;
    private ToString toString;

    public Equals(int test1, int test2, ToString toString) {
        this.test1 = test1;
        this.test2 = test2;
        this.toString = toString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equals equals = (Equals) o;
        return test1 == equals.test1 &&
                test2 == equals.test2 &&
                Objects.equals(toString, equals.toString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(test1, test2, toString);
    }

    @Override
    public String toString() {
        return "Equals{" +
                "test1=" + test1 +
                ", test2=" + test2 +
                ", toString=" + toString +
                '}';
    }

    public static void main(String[] args) {
        /*
        判断两个引用类型的对象是否相等
        但是在Object类中的equals方法使用了双等号，所以只能判断是否为同一对象，而不能判断对象是否相等
         */
        ToString toString = new ToString();
        Equals equals1 = new Equals(1, 2, toString);
        Equals equals2 = new Equals(1, 2, toString);
        System.out.println(equals1.equals(equals2));
        System.out.println(equals1 == equals2);
    }
}
