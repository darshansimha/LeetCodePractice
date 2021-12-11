package Dec_09;

public class MinimumAddToMakeParenthesisValid {

	public int minAddToMakeValid(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int result = 0;
		int balance = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				balance += 1;
			} else {
				if (balance == 0) {
					result += 1;
				} else {
					balance -= 1;
				}
			}
		}
		result += balance;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumAddToMakeParenthesisValid m = new MinimumAddToMakeParenthesisValid();
		System.out.println(m.minAddToMakeValid("())"));
	}

}
