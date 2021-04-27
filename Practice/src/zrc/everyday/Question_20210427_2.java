package zrc.everyday;

import java.util.Arrays;
import java.util.Scanner;

public class Question_20210427_2 {
    private static int find(int[] nums, int index, long sum, long multi) {
        int count = 0;
        for (int i = index; i < nums.length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if (sum > multi) {
                count += 1 + find(nums, i + 1, sum, multi);
            } else if (nums[i] == 1) {
                count += find(nums, i + 1, sum, multi);
            } else {
                break;
            }
            sum -= nums[i];
            multi /= nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            int[] arr = new int[length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int solution = find(arr, 0, 0, 1);
            System.out.println(solution);
        }
    }
}
