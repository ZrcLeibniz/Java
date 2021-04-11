package zrc.course.algorithm20;

/*
有n个打包机从左到右依次排开，会随机选择一批物品放到每个打包机上
放到每个机器上的物品数量有多有少，由于物品数量不同，需要将物品移动至相同数量才可以打包
每次只能搬运一次物品，物品只能在相邻机器上移动
请计算搬运最小的次数
 */
public class PackageMachine {
    public int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        if (sum % arr.length != 0) {
            return -1;
        }
        int avg = sum / arr.length;
        int leftSum = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = (sum - leftSum - arr[i]) - (arr.length - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                result = Math.max(result, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                result = Math.max(result, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftSum += arr[i];
        }
        return result;
    }
}
