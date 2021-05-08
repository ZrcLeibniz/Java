package zrc;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Problem {
    public static void solution(int num, int step, int[] arr) {
        StringBuilder queue = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            queue.append(i);
        }
        for (int i = 0; i < step; i++) {
            int people = arr[2 * i];
            int x = arr[2 * i + 1];
            int start = queue.indexOf(String.valueOf(people));
            int end = Math.min(start + x + 1, queue.length());
            StringBuilder substring = new StringBuilder(queue.substring(start, end));
            queue.delete(start, end);
            queue = substring.append(queue);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < queue.length(); i++ ) {
            result.append(queue.charAt(i));
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int step = scanner.nextInt();
            int[] arr = new int[step * 2];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            solution(num, step, arr);
        }
    }
}