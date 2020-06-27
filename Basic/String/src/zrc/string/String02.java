package zrc.string;

public class String02 {
    public static void main(String[] args) {
        String s1 = "我是中国人";
        // 返回指定索引出的char值
        char a1 = s1.charAt(1);
        System.out.println(a1);
        // 按字典顺序比较字符串
        System.out.println("abcd".compareTo("abce"));
        // 判断一个字符串是否包含xxx
        System.out.println("hello.java".contains(".java"));
        // 判断一个字符串是否以xxx结尾
        System.out.println("hello.java".endsWith(".java"));
        // 判断两个字符串是否相等
        System.out.println("abc".equals("abc"));
        // 判断两个字符串是否相等（不区分大小写）
        System.out.println("abc".equalsIgnoreCase("ABC"));
        // 将字符串对象转为字节数组
        System.out.println("abcdef".getBytes());
        // 判断某个子字符串在当前字符串中第一次出现处的索引
        System.out.println("abcdabcdabcd".indexOf("bcd"));
        // 判断某个字符串是否为空
        System.out.println("".isEmpty());
        // 输出字符串的长度
        System.out.println("dfrghj".length());
        // 判断某个子字符串在当前子字符串中最后一次出现的索引
        System.out.println("ldcjshbgdcj".lastIndexOf("dcj"));
        // String的父接口就是CharSequence
        // 使用新字字符串替换原有子字符串
        System.out.println("http://www.baidu.com".replace("baidu", "souhu"));
        // 拆分字符串
        System.out.println("1980-10-11".split("-"));
        // 判断某个字符串是否以xxx开头
        System.out.println("baidu.java".startsWith("baidu"));
        // 截取字符串
        System.out.println("http://www.baidu.com".substring(7, 20));
        // 将字符串转换为char数组
        System.out.println("我是中国人".toCharArray());
        // 将当前字符串都转换成小写
        System.out.println("ABfgKi".toLowerCase());
        // 将当前字符串转换为大写
        System.out.println("JHVaxaYh".toUpperCase());
        // 取出字符串前后的空白
        System.out.println("   cncnc   hdisi us  ".trim());
        // String中唯一的静态方法，将非字符串转换为字符串
        System.out.println(String.valueOf(true));
        //
    }
}
