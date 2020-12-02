import java.util.ArrayList;
import java.util.HashSet;


public class Test {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //HashSet<Integer> hashSet = new HashSet<Integer>();
        ArrayList<Integer> hashSet = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
            if (hashSet.size() > k) {
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        boolean b = containsNearbyDuplicate(nums, 2);
        System.out.println(b);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
