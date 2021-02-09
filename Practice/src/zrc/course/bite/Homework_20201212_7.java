package zrc.course.bite;

import java.util.Random;
import java.util.Scanner;

public class Homework_20201212_7 {
    public static void main(String[] args) {
        while (true) {
            GuessNum guessNum = new GuessNum();
            int menu = guessNum.menu();
            if (menu == 1) {
                guessNum.guessNumber();
            } else {
                break;
            }
        }
    }
}

class GuessNum {
    int target;
    Scanner scanner = new Scanner(System.in);

    public GuessNum() {
        this.target = new Random().nextInt(101);
    }

    public int menu() {
        System.out.println("欢迎来到猜数字游戏");
        System.out.println("进入游戏请输入 1");
        System.out.println("退出游戏请输入 0");
        int chosen = scanner.nextInt();
        return chosen;
    }

    public void guessNumber() {
        while (true) {
            System.out.println("请输入要猜的数字:");
            int cur = scanner.nextInt();
            if (cur > target) {
                System.out.println("比目标值大一些");
            } else if (cur < target) {
                System.out.println("比目标值小一些");
            } else {
                System.out.println("恭喜你，猜对了");
                break;
            }
        }
    }


}