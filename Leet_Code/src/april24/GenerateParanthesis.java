package april24;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if(n == 0) {
			return result;
		}
		if(n == 1) {
			result.add("()");
			return result;
		}
		generateParanthesisRec(result, "", n, 0, 0);
		return result;
	}
	public void generateParanthesisRec(List<String> result, String current, int n, int open, int close) {
		System.out.println(current + " open : " + open + " close : " + close);
		if(current.length() == 2 * n) {
			result.add(current);
			return;
		}
		if(open < n) {
			generateParanthesisRec(result, current + "(", n, open + 1, close);
		}
		if(close < open) {
			generateParanthesisRec(result, current + ")", n, open, close + 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParanthesis g = new GenerateParanthesis();
		
		System.out.println(g.generateParenthesis(3));
	}

}
