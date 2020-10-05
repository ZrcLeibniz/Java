
public class Test {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3 ,3, 4};
        int i = removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        int index = 1;
        while (p2 < nums.length) {
            if (nums[p1] == nums[p2]) {
                p1++;
                p2++;
            } else {
                nums[index] = nums[p2];
                index++;
                p1++;
                p2++;
            }
        }
        return index;
    }
}