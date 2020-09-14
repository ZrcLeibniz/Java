package zrc.zoom;

import java.util.Random;

/*
使用数组模拟一个洗牌程序
 */
public class CrackNuts11 {

    public static void main(String[] args) {
        char[] card = card();
        for (int i = 0; i < card.length; i++) {
            System.out.println(card[i]);
        }
    }

    private static char[] card() {
        char[] array = new char[13];
        Random random = new Random();
        for (int i = 0; i < 13; i++) {
            int card = random.nextInt(13);
            if (card == 0) {
                array[i] = 'A';
            } else if (card == 10) {
                array[i] = 'J';
            } else if (card == 11) {
                array[i] = 'Q';
            } else if (card == 12) {
                array[i] = 'K';
            } else {
                array[i] = Integer.toString(card + 1).charAt(0);
            }
        }
        return array;
    }
}
