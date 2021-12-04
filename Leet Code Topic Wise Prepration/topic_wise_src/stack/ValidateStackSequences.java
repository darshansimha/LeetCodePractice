package stack;

import java.util.Stack;

public class ValidateStackSequences {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = pushed.length;
		
		int pop = 0;
		for (int i : pushed) {
			stack.push(i);
			while(!stack.isEmpty() && pop < len && stack.peek() == popped[pop]) {
				stack.pop();
				pop++;
			}
		}

		return pop == len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateStackSequences v = new ValidateStackSequences();
		System.out.println(v.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
	}

}
