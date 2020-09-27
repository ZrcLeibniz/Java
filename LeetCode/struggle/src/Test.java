import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] a = {-1, 0,1, 2,-1,-4};
        List<List<Integer>> lists = threeSum(a);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int target = 0; target < nums.length; target++) {
            if (nums[target] > 0) {
                break;
            }
            if (target > 0 && nums[target] == nums[target - 1]) {
                continue;
            }
            int l = target + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[target] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[target], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                }
            }
        }
        return result;
    }
}
