package zrc.string;

public class String02 {
    public static void main(String[] args) {
        String s1 = "我是中国人";
        char a1 = s1.charAt(1);
        System.out.println(a1);
        System.out.println("abcd".compareTo("abce"));
        // 判断一个字符串是否包含xxx
        System.out.println("hello.java".contains(".java"));
        // 判断一个字符串是否以xxx结尾
        System.out.println("hello.java".endsWith(".java"));
    }
}
