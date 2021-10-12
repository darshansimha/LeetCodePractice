package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0) {
			return result;
		}
		if (n == 1) {
			result.add("()");
			return result;
		}

		generateParenthesisRec(n, n, n, new StringBuilder(), result);
		return result;
	}

	public void generateParenthesisRec(int n, int open, int close, StringBuilder current, List<String> result) {
		if (current.length() == n * 2) {
			result.add(current.toString());
			return;
		}
		if (open < close) {
			generateParenthesisRec(n, open, close - 1, new StringBuilder().append(current).append(")"), result);
		}
		if (open > 0) {
			generateParenthesisRec(n, open - 1, close, new StringBuilder().append(current).append("("), result);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParanthesis g = new GenerateParanthesis();
		System.out.println(g.generateParenthesis(3));
	}

}
