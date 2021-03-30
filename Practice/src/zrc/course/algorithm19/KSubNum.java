package zrc.course.algorithm19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
给定一个数组arr，求差值为k的去重数字对
 */
public class KSubNum {
    public List<List<Integer>> solution(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer integer : set) {
            if (set.contains(integer + k)) {
                result.add(Arrays.asList(integer, integer + k));
            }
        }
        return result;
    }
}
