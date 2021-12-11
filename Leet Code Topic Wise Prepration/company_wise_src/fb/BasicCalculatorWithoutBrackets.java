package Dec_08;

import java.util.Stack;

public class BasicCalculatorWithoutBrackets {
	public int calculate(String s) {
		int result = 0;
		if (s == null || s.length() == 0) {
			return result;
		}
		if (s.length() == 1) {
			return s.charAt(0) - '0';
		}
		char[] exp = s.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int currentNumber = 0;
		char operation = '+';
		int lastNumber = 0;
		int idx = 0;
		int len = s.length();
		for (char curr : exp) {
			if (Character.isDigit(curr)) {
				currentNumber = currentNumber * 10 + curr - '0';
			}
			if (!Character.isWhitespace(curr) && !Character.isDigit(curr) || idx == len - 1) {
				if (operation == '+') {
					stack.push(currentNumber);
				} else if (operation == '-') {
					stack.push(-currentNumber);
				} else if (operation == '*') {
					lastNumber = stack.pop();
					stack.push(lastNumber * currentNumber);
				} else if (operation == '/') {
					lastNumber = stack.pop();
					if (currentNumber != 0) {
						stack.push(lastNumber / currentNumber);
					} else {
						return Integer.MAX_VALUE;
					}
				}
				operation = curr;
				currentNumber = 0;

			}
			idx++;
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculatorWithoutBrackets b = new BasicCalculatorWithoutBrackets();
		System.out.println(b.calculate("3+2*2"));
	}

}
