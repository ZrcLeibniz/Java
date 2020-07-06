package zrc.test.linear;

import zrc.linear.Stack;

public class ReversePolishNotationTest {
    public static void main(String[] args) {
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        System.out.println(calculate(notation));
    }

    public static int calculate(String[] notation) {
        Stack<Integer> oprands = new Stack<>();
        for (int i = 0; i < notation.length; i++) {
            String curr = notation[i];
            Integer pop1;
            Integer pop2;
            Integer result;
            switch (curr) {
                case "+":
                    pop1 = oprands.pop();
                    pop2 = oprands.pop();
                    result = pop1 + pop2;
                    oprands.push(result);
                    break;
                case "-":
                    pop1 = oprands.pop();
                    pop2 = oprands.pop();
                    result = pop2 - pop1;
                    oprands.push(result);
                    break;
                case "*":
                    pop1 = oprands.pop();
                    pop2 = oprands.pop();
                    result = pop1 * pop2;
                    oprands.push(result);
                    break;
                case "/":
                    pop1 = oprands.pop();
                    pop2 = oprands.pop();
                    result = pop2 / pop1;
                    oprands.push(result);
                    break;
                default:
                    oprands.push(Integer.parseInt(curr));
                    break;
            }
        }
        return oprands.pop();
    }
}
