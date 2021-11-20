package String;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParanthesis {

	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> indexToRemove = new HashSet<Integer>();
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == '(') {
				stack.push(i);
			} else if (current == ')') {
				if (stack.isEmpty()) {
					indexToRemove.add(i);
				} else {
					stack.pop();
				}
			}
		}
		while (!stack.isEmpty()) {
			indexToRemove.add(stack.pop());
		}
		for(int i = 0; i < s.length(); i++) {
			if(!indexToRemove.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumRemoveToMakeValidParanthesis m = new MinimumRemoveToMakeValidParanthesis();
		System.out.println(m.minRemoveToMakeValid("))(("));
	}

}
