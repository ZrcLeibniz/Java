package zrc.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date nowTime = new Date();
        System.out.println(nowTime);
        // yyyy 年 MM 月 dd 日 HH时 mm 分 ss秒 SSS毫秒
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
        String format = simpleDateFormat.format(nowTime);
        System.out.println(format);
        String time = "2008-08-08 08:08:08:888";
        Date parse = simpleDateFormat.parse(time);
        System.out.println(parse);
        // 获取自1970年1月1日00：00：00：000到当前系统时间的毫秒数
        long l = System.currentTimeMillis();
        System.out.println(l);

//        System.out 【out是System类的静态变量】
//        System.out.println() 【println()方法不是System类的，是PrintSystem类的方法】
//        System.gc() 【建议启动垃圾回收器】
//        System.currentTimeMillis() 【获取自1970年1月1日00：00：00：000到当前系统时间的毫秒数】
//        System.exit(0) 【退出JVM】

    }
}
