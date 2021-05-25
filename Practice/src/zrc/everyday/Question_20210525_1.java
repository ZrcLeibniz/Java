package zrc.everyday;

import java.util.Scanner;

public class Question_20210525_1 {
    public static int solution(String[] begins, String[] ends) {
        int beginYear = Integer.parseInt(begins[0]);
        int endYear = Integer.parseInt(ends[0]);
        int beginMonth = Integer.parseInt(begins[1]);
        int endMonth = Integer.parseInt(ends[1]);
        int beginDay = Integer.parseInt(begins[2]);
        int endDay = Integer.parseInt(ends[2]);
        int result = 0;
        for (int i = beginYear; i <= endYear; i++) {
            int[] ints = yearSum(i);
            result += ints[0];
        }
        int subBegin = 0;
        int[] beginTable = yearSum(beginYear);
        for (int i = 1; i <= beginMonth; i++) {
            subBegin += beginTable[i];
        }
        int dayB = dayOfMonth(beginYear, beginMonth);
        int subDayB = dayB - beginDay + 1;
        subBegin -= isValid(beginMonth) ? subDayB : subDayB * 2;
        int[] endTable = yearSum(endYear);
        int subEnd = 0;
        for (int i = 12; i > endMonth; i--) {
            subEnd += endTable[i];
        }
        int dayE = dayOfMonth(endYear, endMonth);
        int subDayE = dayE - endDay;
        subEnd += isValid(endMonth) ? subDayE : subDayE * 2;
        int subSum = subBegin + subEnd;
        return result - subSum;
    }

    private static int dayOfMonth(int year, int month) {
        if (isOYear(year) && month == 2) {
            return 29;
        } else if (month == 2) {
            return 28;
        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else {
            return 30;
        }
    }

    private static boolean isOYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

    private static int[] yearSum(int year) {
        boolean flag = isOYear(year);
        int[] yearCount = new int[13];
        yearCount[1] = 62;
        yearCount[2] = flag ? 29 : 28;
        yearCount[3] = 31;
        yearCount[4] = 60;
        yearCount[5] = 31;
        yearCount[6] = 60;
        yearCount[7] = 31;
        yearCount[8] = 62;
        yearCount[9] = 60;
        yearCount[10] = 62;
        yearCount[11] = 30;
        yearCount[12] = 62;
        for (int i = 1; i < 13; i++) {
            yearCount[0] += yearCount[i];
        }
        return yearCount;
    }

    private static boolean isValid(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] begin = new String[3];
            String[] end = new String[3];
            for (int i = 0; i < begin.length; i++) {
                begin[i] = scanner.next();
            }
            for (int i = 0; i < end.length; i++) {
                end[i] = scanner.next();
            }
            int solution = solution(begin, end);
            System.out.println(solution);
        }
    }
}
