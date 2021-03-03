package zrc.course.algorithm12;

import java.util.LinkedList;

public class SlideWindow {
    private int L;
    private int R;
    private int[] a;
    private LinkedList<Integer> max;

    public SlideWindow(int[] a) {
        this.a = a;
        this.L = -1;
        this.R = 0;
        max = new LinkedList<>();
    }

    public void addNumberFromRight() {
        if (R == a.length) {
            return;
        }
        while (!max.isEmpty() && a[max.peekLast()] <= a[R]) {
            max.pollLast();
        }
        max.addLast(a[R++]);
    }

    public void removeNumberFromLeft() {
        if (L >= R - 1) {
            return;
        }
        L++;
        if (L == max.peekFirst()) {
            max.pollLast();
        }
    }

// 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑倒最右边，窗口每次向右边滑一个位置
// 例如，数组为[4,3,5,4,3,3,6,7],窗口大小为3时
// [4,3,5],4,3,3,6,7    max=5
// 4,[3,5,4],3,3,6,7    max=5
// 4,3,[5,4,3],3,6,7    max=5
// 4,3,5,[4,3,3],6,7    max=4
// 4,3,5,4,[3,3,6],7    max=6
// 4,3,5,4,3,[3,6,7]    max=7
// 请实现一个函数
// 输入：整型数组：arr，窗口大小：w
// 输出：一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
    public int[] getWindowMax(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w ) {
            return null;
        }
        int[] result = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> max = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!max.isEmpty() && arr[max.peekLast()] <= arr[i]) {
                max.pollLast();
            }
            max.addLast(i);
            if (i - max.peekFirst() == w) {
                max.pollFirst();
            }
            if (i >= w - 1) {
                result[index++] = arr[max.peekFirst()];
            }
        }
        return result;
    }
}
