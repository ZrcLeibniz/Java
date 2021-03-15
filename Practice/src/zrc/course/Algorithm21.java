package zrc.course;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Algorithm21 {
}

// 对于一个栈添加一个操作，可以随时获得其最小值，要求时间复杂度为O(1)
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || min.peek() > val) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public int pop() {
        min.pop();
        return stack.pop();
    }

    public int getMin() {
        return min.peek();
    }
}

/*
动态规划的空间压缩技巧
 */

/*
给定一个数组arr，已知其中所有值都是非负的，将这个数组看作一个容器请返回容器能装多少水
 */
class MaxWater {
    public int solution(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int leftMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, arr[j]);
            }
            int rightMax = 0;
            for (int j = i; j < arr.length; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }
            result += Math.max(Math.min(leftMax, rightMax) - arr[i], 0);
        }
        return result;
    }

    // 对于内部寻找左边最大值和右边最大值的操作我们可以通过辅助数组来将结果保存下来
    // 空间换时间
    public int solutionII(int[] arr) {
        int result = 0;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }
        rightMax[rightMax.length - 1] = arr[arr.length - 1];
        for (int i = rightMax.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(arr[i], rightMax[i + 1]);
        }
        for (int i = 1; i < arr.length - 1; i++) {
            result += Math.max(Math.min(leftMax[i], rightMax[i]) - arr[i], 0);
        }
        return result;
    }
}

/*
给定一个数组arr长度为N，你可以把任意长度大于0且小于N的前缀作为左部分，剩下的作为右部分
但是每种划分下都有左部分的最大值和有部分的最大值，请返回最大的，左部分最大值减去右部分最大值的绝对值
 */
class ArrayMaxSubAbs {
    public int solution(int[] arr) {
        int result = Integer.MIN_VALUE;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        rightMax[rightMax.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(leftMax[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, Math.abs(leftMax[i] - rightMax[i]));
        }
        return result;
    }

    // 首先我们需要找到整个数组的全局最大值
    // 因为不管怎么切，只要这个数是最大的，无论在左在右，都是它减别人。 或者别人减它
    // 如果max被划分进左部分，那么我们需要让右部分的值尽可能的小，那就让右部分的值为arr[arr.length - 1]，因为无论怎么划分，都包含它
    // 如果max被划分进右部分，那么我们需要让左部分的值尽可能的小，那就让左部分的值为arr[0]，同理
    public int solutionII(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            max = Math.max(value, max);
        }
        int sub = Math.min(arr[0], arr[arr.length - 1]);
        return Math.abs(max - sub);
    }
}

/*
如果一个字符串为str，把字符串str前面任意部分挪到后面形成的字符串叫str的旋转词
现给定两个字符串a和b，请判断a和b是否互为旋转词
 */
class IsRotateString {
    public boolean solution(String source, String target) {
        String string = source + source;
        return KMP(string, target) != -1;
    }

    private int KMP(String string, String target) {
        if (string == null || target == null || string.length() < 1 || string.length() < target.length()) {
            return -1;
        }
        char[] str1 = string.toCharArray();
        char[] str2 = target.toCharArray();
        int[] next = getNext(str2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private int[] getNext(char[] string) {
        if (string.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[string.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < next.length) {
            if (string[i - 1] == string[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}

/*
现给定一个数组，数组的长度代表咖啡机的个数，数组元素的值代表咖啡机冲泡咖啡的时间
给定一个N，代表有N个人要喝咖啡，切认为喝咖啡的时间为0
先给定一个洗碗机，其效率是a，认为清洗一个咖啡机的时间是a
再给定一个时间d，认为咖啡杯不需要清洗也能自我挥发干净，求泡咖啡到咖啡杯全部干净的总时间
 */
class Coffee {
    private class Machine {
        public int timePoint;
        public int workTime;

        public Machine(int timePoint, int workTime) {
            this.timePoint = timePoint;
            this.workTime = workTime;
        }
    }

    private class MachineComparator implements Comparator<Machine> {
        @Override
        public int compare(Machine o1, Machine o2) {
            return (o1.timePoint + o1.workTime) - (o2.timePoint + o2.workTime);
        }
    }

    public int drink(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<Machine>(new MachineComparator());
        for (int value : arr) {
            heap.add(new Machine(0, value));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heap.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heap.add(cur);
        }
        return process(drinks, a, b, 0, 0);
    }

    public int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1) {
            return Math.min(Math.max(washLine, drinks[index]) + a, drinks[index] + b);
        }
        int wash = Math.max(washLine, drinks[index]) + a;
        int next1 = process(drinks, a, b, index + 1, washLine + a);
        int p1 = Math.max(wash, next1);
        int dry = drinks[index] + b;
        int next2 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }
}

/*
给定一个数组，如果通过调整可以做到arr中任意两个相邻数字相乘是4的倍数，返回true，否则返回false
遍历数组，统计奇数的个数a，包含1个2因子的数的个数b，包含4因子的数的个数c
 */
class FourMultiple {
    public static boolean isRequired(int length, int[] a) {
        int jiShu = 0;
        int four = 0;
        int ouShu = 0;
        for (int i = 0; i <= length - 1; i++) {
            //不符合要求
            if (a[i] <= 0) {
                return false;
            }
            //奇数个数
            if (a[i] % 2 == 1) {
                jiShu++;
            }
            //只是二的倍数个数
            if (a[i] % 2 == 0 && a[i] % 4 != 0) {
                ouShu++;
            }
            //4的倍数
            if (a[i] % 4 == 0) {
                four++;
            }
        }
        //4的倍数大于数组长度的一半-1，可以满足a[i]和a[i+1]中必定有一个是4的倍数，这样漏掉了全是偶数的情况，如2 2 6
        if (four >= length - four - 1) {
            return true;
        }
        //4的倍数的个数必须大于等于奇数个数（如果有奇数的话），同时，偶数个数必须至少2个，1 3 5 4 4 4 2 2 2 2 2 2 2 2 2
        if ((four >= jiShu) && (ouShu >= 2)) {
            return true;
        }
        return false;
    }
}
