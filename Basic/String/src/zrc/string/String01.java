package zrc.string;

public class String01 {
    public static void main(String[] args) {
        String s1 = "Hello World";
        byte[] bytes = {97, 98, 99};
        String s2 = new String(bytes);
        String s3 = new String(bytes, 1, 2);
        char[] chars = {'a', 'b', 'c', 'd'};
        String s4 = new String(chars);
        String s5 = new String(chars, 1, 2);
    }
}
