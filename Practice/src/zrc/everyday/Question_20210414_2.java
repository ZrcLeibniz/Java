package zrc.everyday;

import java.util.Arrays;
import java.util.HashMap;

public class Question_20210414_2 {
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
            max = Math.max(map.get(value), max);
        }
        if (max <= arr.length / 2) {
            return 0;
        }
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
