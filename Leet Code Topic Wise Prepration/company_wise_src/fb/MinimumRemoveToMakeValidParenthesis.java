package Dec_05;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {

	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		Set<Integer> removeIndexes = new HashSet<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					removeIndexes.add(i);
				}
			}
		}
		if (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				removeIndexes.add(stack.pop());
			}
		}
		for(int i = 0; i < s.length(); i++) {
			if(!removeIndexes.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumRemoveToMakeValidParenthesis m = new MinimumRemoveToMakeValidParenthesis();
		System.out.println(m.minRemoveToMakeValid("))(("));
	}

}
