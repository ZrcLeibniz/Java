package zrc.course.algorithm19;

import java.util.Arrays;
import java.util.HashSet;

/*
给定一个包含n个整数元素的集合a，一个包含m个整数元素的集合b
定义magic操作为：从一个集合中抽取一个元素放到另外一个集合中，且操作过后每个集合的平均值都大于之前
求最多可以进行多少次magic操作
 */
public class MagicAction {
    public int solution(int[] A, int[] B) {
        double sumA = 0;
        double sumB = 0;
        for (int i : A) {
            sumA += (double) i;
        }
        for (int i : B) {
            sumB += (double) i;
        }
        if (avg(sumA, A.length) == avg(sumB, B.length)) {
            return 0;
        }
        int[] moreArr = null;
        int[] lessArr = null;
        double moreSum = 0;
        double lessSum = 0;
        if (avg(sumA, A.length) > avg(sumB, B.length)) {
            moreArr = A;
            lessArr = B;
            moreSum = sumA;
            lessSum = sumB;
        } else {
            moreArr = B;
            lessArr = B;
            moreSum = sumB;
            lessSum = sumA;
        }
        Arrays.sort(moreArr);
        HashSet<Integer> set = new HashSet<>();
        for (int i : lessArr) {
            set.add(i);
        }
        int moreSize = moreArr.length;
        int lessSize = lessArr.length;
        int ops = 0;
        for (int i = 0; i < moreArr.length; i++) {
            double cur = moreArr[i];
            if (cur < avg(moreSum, moreSize) && cur > avg(lessSum, lessSize) && !set.contains(cur)) {
                moreSize--;
                lessSize++;
                set.add(moreArr[i]);
                ops++;
                moreSum -= cur;
                lessSum += cur;
            }
        }
        return ops;
    }

    private double avg(double sum, int size) {
        return sum / size;
    }
}
