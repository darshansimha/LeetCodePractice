package Dec_07;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		char curr = ' ';
		for (int i = 0; i < s.length(); i++) {
			curr = s.charAt(i);
			if (Character.isLetterOrDigit(curr)) {
				sb.append(Character.toLowerCase(curr));
			}
		}

		return validatePalindrome(sb.toString());
	}

	private boolean validatePalindrome(String s) {
		if (s == null) {
			return false;
		}
		int left = 0;
		int right = s.length() - 1;

		while (right >= left) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
