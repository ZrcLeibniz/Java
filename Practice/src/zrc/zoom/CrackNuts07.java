package zrc.zoom;

/*
数组中只有一个数出现了1次，其他的数都出现了k次，请输出只出现了1次的数
 */
public class CrackNuts07 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 9, 7, 7, 7, 3, 3, 3, 6, 6, 6, 0, 0, 0};
        int len = arr.length;
        char[][] kRadix = new char[len][];
        int k = 3;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            kRadix[i] = new StringBuilder(Integer.toString(arr[i], k)).reverse().toString().toCharArray();
            if (kRadix[i].length > maxLen) {
                maxLen = kRadix[i].length;
            }
        }
        int[] resArr = new int[maxLen];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < maxLen; j++) {
                if (j >= kRadix[i].length) {
                    resArr[j] += 0;
                } else {
                    resArr[j] += (kRadix[i][j] - '0');
                }
            }
        }
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            res += (resArr[i] % k) * (int)(Math.pow(k, i));
        }
        System.out.println(res);
    }
}
