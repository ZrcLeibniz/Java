package zrc;

import java.util.*;

public class Problem {
    public static int solution(int[] gifts, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int gift : gifts) {
            if (!map.containsKey(gift)) {
                map.put(gift, 1);
            } else {
                Integer num = map.get(gift);
                if (num + 1 > n / 2) {
                    return gift;
                }
                map.put(gift, num + 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        int solution = solution(arr, 5);
        System.out.println(solution);
    }
}