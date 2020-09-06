package zrc.offer;

import java.util.ArrayList;
import java.util.Collections;

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class JZ32 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<>();
        String cur = "";
        helpMin(numbers, cur, result);
        Collections.sort(result);
        return result.get(0);
    }

    private void helpMin(int[] numbers, String cur, ArrayList<String> result) {
        if (numbers.length == 0) {
            for (int i = 0; i < result.size(); i++) {
                if (result.get(i) == cur) {
                    return;
                }
            }
            result.add(cur);
        }
        for (int i = 0; i < numbers.length; i++) {
            int[] temp = new int[numbers.length - 1];
            int count = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (j != i) {
                    temp[count] = numbers[j];
                    count++;
                }
            }
            helpMin(temp, cur + Integer.toString(numbers[i]), result);
        }
    }
}
