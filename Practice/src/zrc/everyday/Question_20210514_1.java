package zrc.everyday;

import java.util.HashMap;

public class Question_20210514_1 {
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
}
