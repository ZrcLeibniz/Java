package zrc.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Course2 {
    public static void main(String[] args) {

    }
}

// 给定一个数组，求如果排序后，相邻两数的最大差值且排序时不能使用非基于比较的排序，要求时间复杂度为O(N)
class Solution3 {
    public int maxGap(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] groupMax = new int[len + 1];
        int[] groupMin = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            groupMin[bid] = hasNum[i] ? Math.min(groupMin[bid], nums[i]) : nums[i];
            groupMax[bid] = hasNum[i] ? Math.max(groupMax[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = groupMax[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, groupMin[i] - lastMax);
                lastMax = groupMax[i];
            }
        }
        return res;
    }

    private int bucket(int num, int len, int min, int max) {
        return (int) ((num - min) * len / (max - min));
    }
}

// 使用数组实现栈
class ArrayStack {
    private Integer[] arr;
    private Integer size;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[size - 1];
    }

    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        }
        arr[size++] = obj;
    }

    public int poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Stack is empty");
        }
        return arr[--size];
    }
}

// 使用数组实现队列
class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer start;
    private Integer end;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        start = 0;
        end = 0;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

    public void push(Integer obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[end] = obj;
        end = end == arr.length - 1 ? 0 : end + 1;
    }

    public Integer poll() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int temp = start;
        start = start == arr.length - 1 ? 0 : start + 1;
        return arr[temp];
    }
}

// 实现一个栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
class ArrayStackII {
    private Integer[] arr;
    private Integer index;
    private Integer[] min;
    private Integer minIndex;

    public ArrayStackII(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size than less 0");
        }
        arr = new Integer[initSize];
        min = new Integer[initSize];
        index = 0;
        minIndex = 0;
    }

    public Integer peek() {
        if (index < 0) {
            return null;
        }
        return arr[index - 1];
    }

    public void push(Integer obj) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The stack is full");
        }
        arr[index++] = obj;
        if (minIndex == 0) {
            min[minIndex++] = obj;
        } else {
            min[minIndex++] = min[minIndex - 1] <= obj ? min[minIndex] : obj;
        }
    }

    public Integer poll() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        minIndex--;
        return arr[--index];
    }

    public Integer minNum() {
        if (minIndex == 0) {
            throw new ArrayIndexOutOfBoundsException("The stack is empty");
        }
        return min[minIndex - 1];
    }
}

// 如何使用队列实现栈
class QueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;

    public QueueStack() {
        data = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }


    public void push(int pushInt) {
        data.add(pushInt);
    }

    public int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        help.add(res);
        swap();
        return res;
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        while (data.size() > 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> temp = help;
        help = data;
        data = temp;
    }
}

// 如何使用栈实现队列
class StackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public StackQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void push(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is full");
        } else if (!stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}