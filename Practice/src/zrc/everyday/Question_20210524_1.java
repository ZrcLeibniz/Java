package zrc.everyday;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Question_20210524_1 {
    public static List<String> solution(int year) {
        List<String> result = new ArrayList<>();
        result.add(year + "-01-01");
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, Calendar.JANUARY, 1);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        int day = 0;
        if (i == 2) {
            day = 15 + i;
        } else if (i == 1) {
            day = 16;
        } else {
            day = 15 + 7 - (i - 2);
        }
        String s = day > 10 ? "" + day : "0" + day;
        result.add(year + "-01-" + s);
        calendar.set(year, Calendar.FEBRUARY, 1);
        i = calendar.get(Calendar.DAY_OF_WEEK);
        if (i == 2) {
            day = 15 + i;
        } else if (i == 1) {
            day = 16;
        } else {
            day = 15 + 7 - (i - 2);
        }
        s = day > 10 ? "" + day : "0" + day;
        result.add(year + "-02-" + s);
        calendar.set(year, Calendar.MAY, 31);
        i = calendar.get(Calendar.DAY_OF_WEEK);
        if (i == 2) {
            day = 31;
        } else if (i == 1) {
            day = 31 - (7 - i);
        } else {
            day = 31 - (i - 2);
        }
        result.add(year + "-05-" + day);
        result.add(year + "-07-04");
        calendar.set(year, Calendar.SEPTEMBER, 1);
        i = calendar.get(Calendar.DAY_OF_WEEK);
        if (i == 2) {
            day = 1;
        } else if (i == 1) {
            day = 2;
        } else {
            day = 1 + 7 - (i - 2);
        }
        s = day > 10 ? "" + day : "0" + day;
        result.add(year + "-09-" + s);
        calendar.set(year, Calendar.NOVEMBER, 1);
        i = calendar.get(Calendar.DAY_OF_WEEK);
        if (i <= 5) {
            day = 22 + (5 - i);
        } else {
            day = 7 - i + 27;
        }
        s = day > 10 ? "" + day : "0" + day;
        result.add(year + "-11-" + s);
        result.add(year + "-12-25");
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            List<String> solution = solution(year);
            for (String s : solution) {
                System.out.println(s);
            }
        }
    }
}