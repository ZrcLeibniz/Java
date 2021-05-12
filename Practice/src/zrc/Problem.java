package zrc;

import java.util.*;

public class Problem {
    public static String solution(String card, int num) {
        String[] word = card.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            int left = 0;
            int right = word.length / 2;
            int step = 0;
            StringBuilder cur = new StringBuilder();
            while (step < word.length / 2) {
                cur.append(word[left++]);
                cur.append(" ");
                cur.append(word[right++]);
                cur.append(" ");
                step++;
            }
            cur.deleteCharAt(cur.length() - 1);
            word = cur.toString().split(" ");
        }
        for (String s : word) {
            result.append(s);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();

        }
    }
}