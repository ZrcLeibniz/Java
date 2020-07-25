package zrc.offer;

/*
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
 */
public class JZ1 {
    public static boolean Find(int target, int[][] array) {
        // 左上角的元素为最小值，右下角的元素为最大值，target在这之外，此二维数组中必然不存在。
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        } else {
            if (target < array[0][0] || target > array[array.length - 1][array[0].length - 1]) {
                return false;
            }
            int i = 0;
            int j = array[0].length - 1;
            while (i <= array.length - 1 && j >= 0) {
                if (array[i][j] == target) {
                    return true;
                } else if (array[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean find = Find(5, a);
        System.out.println(find);
    }
}
