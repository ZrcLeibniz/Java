package zrc.course;

import java.util.HashMap;

public class Algorithm18 {
}

/*
    给定一个有序数组，代表数轴上从左到右有n个点arr[0]、arr[1]...arr[n-1]，给定
    一个整数L，代表一根长度为L的绳子，求绳子最多能覆盖其中的几个点
 */
class RopeRange {
    public int solution(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        int result = 0;
        while (left < nums.length) {
            while (right < nums.length && (nums[right] - nums[left]) <= limit) {
                right++;
            }
            result = Math.max(result, right - left);
            left++;
        }
        return result;
    }
}

/*
小虎去附近的商店买苹果，有6个每袋和8个每袋，如果现在要购买n的苹果，请返回最少的袋子数
如果不能正好装下，返回-1
 */
class BuyApple {
    public int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        while (bag8 >= 0 && rest < 24) {
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1) {
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    private int minBagBase6(int rest) {
        return rest % 6 == 0 ? (rest / 6) : -1;
    }

    // 为什么可以作弊。。。。。。? ? ? ? ? ?
    public int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }
}

/*
牛羊吃草问题
    每次可以吃4的幂次方的草，必须吃，牛羊都很聪明，谁先吃完谁赢，求解先手赢还是后手赢
 */
class CowAndSheep {
    public String winner(int n) {
        if (n < 5) {
            return (n == 0 || n == 2) ? "后手" : "先手";
        }
        int base = 1;
        while (base <= n) {
            if (winner(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) {
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    // 为什么又可以作弊。。。。。。？？？？？？
    public String winner___(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "后手";
        } else {
            return "先手";
        }
    }
}

/*
有一些排成一行的正方形。每个正方形已经没染成红色或者绿色。
现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色，这个正方形的颜色将会被覆盖
现在的目标是在染完色之后，每个红色R都比每个绿色G距离最左侧近
最少需要染几个正方形
 */
class ColorOfSquarePoint {
    public int minPaint(String s) {
        char[] str = s.toCharArray();
        int N = str.length;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int L = 0; L <= N; L++) {
            int[] countOfColor = countOfColor(L, str);
            if (L == 0) {
                count = countOfColor[1];
            } else if (L == N) {
                count = countOfColor[0];
            } else {
                count = countOfColor[0] + countOfColor[1];
            }
            min = Math.min(count, min);
        }
        return min;
    }

    private int[] countOfColor(int point, char[] string) {
        int red = 0;
        int green = 0;
        for (int i = point; i >= 0; i--) {
            if (string[i] == 'G') {
                green++;
            }
        }
        for (int i = point; i < string.length; i++) {
            if (string[i] == 'R') {
                red++;
            }
        }
        return new int[]{red, green};
    }

    // 从上述代码可以发现，每次走到一个位置的时候，我们都需要去遍历整个数组，来确定左右两边的颜色数量
    // 我们可以准备两个数组来分别记录左边长度为L时候，左边的绿色个数和右边的红色个数
    public int colorOfSquare(String string) {
        char[] square = string.toCharArray();
        int[] leftGreen = new int[string.length() + 1];
        int[] rightRed = new int[string.length() + 1];
        leftGreen[0] = 0;
        rightRed[rightRed.length - 1] = 0;
        for (int i = 1; i < leftGreen.length; i++) {
            leftGreen[i] = (square[i] == 'G' ? 1 : 0) + leftGreen[i - 1];
        }
        for (int i = rightRed.length - 2; i >= 0; i--) {
            rightRed[i] = (square[i] == 'R' ? 1 : 0) + leftGreen[i + 1];
        }
        int min = Integer.MAX_VALUE;
        for (int L = 0; L <= square.length; L++) {
            int count = leftGreen[L] + rightRed[L];
            min = Math.min(count, min);
        }
        return min;
    }
}

/*
给定一个N*M的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的变长长度
 */
class MaxLengthMatrix {
    public int maxAllOneBorder(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int max = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                for (int border = 1; border <= Math.min(N - row, M - col); border++) {
                    // 验证这个唯一产生的正方形是不是每条边都是1
                    if (isOne(matrix, row, col, border)) {
                        max = Math.max(border, max);
                    }
                }
            }
        }
        return max;
    }

    private boolean isOne(int[][] matrix, int row, int col, int border) {
        for (int i = row; i < matrix.length; i++) {
            if (matrix[i][col] != 1 || matrix[i][col + border - 1] != 1) {
                return false;
            }
        }
        for (int i = col; i < matrix[col].length; i++) {
            if (matrix[row][i] != 1 || matrix[row + border - 1][i] != 1) {
                return false;
            }
        }
        return true;
    }

    // 对于这个问题上述代码的时间复杂度是O(n^4)，我们可以将内部检查使用额外空间替换
    public int solution(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] rightOne = new int[M][N];
        int[][] downOne = new int[M][N];
        int max = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col >= 0; col--) {
                if (col == matrix[row].length - 1) {
                    rightOne[row][col] = matrix[row][col] == 1 ? 1 : 0;
                    continue;
                }
                rightOne[row][col] = rightOne[row][col + 1] + (rightOne[row][col] == 1 ? 1 : 0);
            }
        }
        for (int col = matrix[0].length - 1; col >= 0; col--) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                if (row == matrix.length - 1) {
                    downOne[row][col] = matrix[row][col] == 1 ? 1 : 0;
                    continue;
                }
                downOne[row][col] = downOne[row + 1][col] + (matrix[row][col] == 1 ? 1 : 0);
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                for (int border = 1; border < Math.min(N - row, M - col); border++) {
                    if (rightOne[row][col] >= border && downOne[row][col] >= border) {
                        if (downOne[row][col + border - 1] >= border) {
                            if (downOne[row + border - 1][col] >= border) {
                                max = Math.max(border, max);
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}

/*
给定一个函数f，可以1~5的数字等概率返回一个。请加工出1~7的数字等概率返回一个的函数g

给定一个函数f，可以a~b的数字等概率返回一个。请加工出1~7的数字等概率返回一个的函数g
【与1同理，将f加工成0/1生成器，之后，按照二进制拼出答案】

给定一个函数f，以p概率返回0，以1-p概率返回1。请加工出等概率返回0和1的的函数g
 */
class MachiningFunction {
    public int f() {
        return (int)(Math.random() * 5) + 1;
    }

    private int ro1() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public int g() {
        int res = 0;
        do {
            res = (ro1() << 2 + ro1() << 1 + ro1());
        } while (res == 7);
        return res + 1;
    }

    // 假定p为1 / 3
    public int fII() {
        int res = (int) (Math.random() * 3 + 1);
        return res == 1 ? 0 : 1;
    }

    public int ro2() {
        int res = 0;
        do {
            res = (ro2() << 1) + ro2();
        } while (res == 0 || res == 3);
        return res == 2 ? 1 : 0;
    }
}