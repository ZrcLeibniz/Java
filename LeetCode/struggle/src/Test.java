
public class Test {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                nums3[index++] = nums1[p1++];
            } else {
                nums3[index++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            nums3[index++] = nums1[p1++];
        }
        while (p2 < n) {
            nums3[index++] = nums2[p2++];
        }
        for (int i = 0; i < nums3.length; i++) {
            nums1[i] = nums3[i];
        }
    }
}
