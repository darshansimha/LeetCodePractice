package Dec_05;

public class ValidPalindrome2 {
	public boolean validPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int left = 0;
		int len = s.length();
		int right = len - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
			right--;
			left++;
		}
		return true;
	}
	private boolean isPalindrome(String s, int start, int end) {
		while(start < end) {
			if(s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome2 v = new ValidPalindrome2();
		System.out.println(v.validPalindrome("abc"));
	}

}
