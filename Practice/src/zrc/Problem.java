package zrc;


import java.util.*;

public class Problem {
    public static String solution(String x) {
        StringBuilder temp = new StringBuilder(x);
        return temp.reverse().toString();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String x = scanner.next();
            String solution = solution(x);
            System.out.println(solution);
        }
    }
}