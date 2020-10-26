import zrc.leetcode.MaxSlidingWindowSolution;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = MaxSlidingWindowSolution.maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
