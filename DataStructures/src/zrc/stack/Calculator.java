package zrc.stack;

public class Calculator {
	public static void main(String[] args) {
		String expression = "70+2*6-2";
		CalStack operStack = new CalStack(10);
		CalStack numStack = new CalStack(10);
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";
		while (true) {
			ch = expression.substring(index, index + 1).charAt(0);
			if (operStack.isOper(ch)) {
				if (!operStack.isEmpty()) {
					if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
						// System.out.println(res);
					} else {
						operStack.push(ch);
						// System.out.println(ch);
					}
				} else {
					operStack.push(ch);
					// System.out.println(ch);
				}
			} else {
				// numStack.push(ch - 48);
				// System.out.println(ch);
				keepNum += ch;
				if (index == expression.length() - 1) {
					numStack.push(Integer.parseInt(keepNum));
				} else if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
					numStack.push(Integer.parseInt(keepNum));
					keepNum = "";
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		while (true) {
			if (operStack.isEmpty()) {
				break;
			} else {
				num1 = numStack.pop();
				num2 = numStack.pop();
				oper = operStack.pop();
				res = numStack.cal(num1, num2, oper);
				numStack.push(res);
			}
		}
		System.out.printf("表达式%s = %d", expression, numStack.pop());
	}
}

class CalStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;

	public CalStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}

	public boolean isFull() {
		return top == maxSize - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("栈满，入栈失败");
			return;
		} else {
			top++;
			stack[top] = value;
		}
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈空，出栈失败");
		} else {
			int value = stack[top];
			top--;
			return value;
		}
	}

	public void list() {
		if (isEmpty()) {
			System.out.println("栈空");
			return;
		} else {
			for (int i = top; i >= 0; i--) {
				System.out.printf("当前是栈中的第%d个元素，其值是%d", i, stack[i]);
			}
		}
	}

	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		} else if (oper == '+' || oper == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	public boolean isOper(char val) {
		return val == '+' || val == '-' || val == '*' || val == '/';
	}

	public int cal(int num1, int num2, int oper) {
		int res = 0;
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}

	public int peek() {
		return stack[top];
	}
}