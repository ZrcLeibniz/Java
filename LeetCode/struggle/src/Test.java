import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int[] ints = twoSum(nums, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] temp = new int[nums.length];
        int r0 = 0;
        int r1 = 0;
        int i = 0;
        int j = 0;
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r0 = nums[l];
                r1 = nums[r];
                break;
            }
        }
        for (; i < nums.length; i++) {
            if (temp[i] == r0) {
                result[0] = i;
                break;
            }
        }
        for (; j < nums.length; j++) {
            if (temp[j] == r1 && i != j) {
                result[1] = j;
            }
        }
        return result;
    }
}
