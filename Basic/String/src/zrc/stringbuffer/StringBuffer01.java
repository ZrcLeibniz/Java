package zrc.stringbuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        // 频繁的字符串拼接就是频繁的创建对象
        String s = "";
        for (int i = 0; i < 100; i++) {
            s = s + i;
            System.out.println(s);
        }
        // 如果需要频繁使用字符串拼接，建议使用StringBuffer或StringBuilder
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        stringBuffer.append("b");
        stringBuffer.append("c");
        stringBuffer.append("d");
        // StringBuilder和StringBuffer的区别在于线程不安全与安全
    }
}
