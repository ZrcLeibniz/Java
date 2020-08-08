package zrc.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date firstTime = simpleDateFormat.parse("2020-8-7 11:40:00");
        timer.schedule(new LogTimerTask(), firstTime, 1000 * 10);
    }
}

class LogTimerTask extends TimerTask {

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format + "成功完成一次数据备份");
    }
}