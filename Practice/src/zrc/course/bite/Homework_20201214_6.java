package zrc.course.bite;

import zrc.linear.Stack;

public class Homework_20201214_6 {
    public static void main(String[] args) {
        Homework_20201214_6 test = new Homework_20201214_6();
        System.out.println(test.printPosition(472937));
    }

    public StringBuilder printPosition (int i) {
        Stack<Integer> stack = new Stack<>();
        if (i == 0) {
            return new StringBuilder("0");
            while (i != 0) {
                stack.push(i % 10);
                i = i / 10;
            }
            StringBuilder result = new StringBuilder();
            result.append("{");
            for (Integer integer : stack) {
                result.append(integer);
                result.append(",");
            }
            result.deleteCharAt(result.length() - 1);
            result.append("}");
            return result;
        }
    }

}
