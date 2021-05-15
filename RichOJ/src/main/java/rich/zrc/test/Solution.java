package rich.zrc.test;

public class Solution {
    public int[] twoSum(int[] arr, int target) {
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4};
        int[] result = solution.twoSum(arr, 5);
        if (result.length == 2 && result[0] == 0 && result[1] == 3) {
            System.out.println("case OK");
        } else {
            System.out.println("case error");
        }
    }
}
