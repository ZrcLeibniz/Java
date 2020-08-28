package zrc.offer;

import java.util.Arrays;
import java.util.Stack;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
假设输入的数组的任意两个数字都互不相同。
 */
public class JZ23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        int[] pop = sequence.clone();
        Arrays.sort(sequence);
        return isAfterErgodic(sequence, pop);
    }

    private boolean isAfterErgodic(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        if (push.length == 0 || pop.length == 0) {
            return false;
        }
        int index = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (!stack.isEmpty() && stack.peek() == pop[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
