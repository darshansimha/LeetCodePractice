package String;

public class ValidPalindrome2 {
	public boolean validPalindrome(String s) {
		return helper(0, s.length() - 1, s, 0);
	}

	private boolean helper(int start, int end, String s, int deleteNum) {
		if (deleteNum > 1)
			return false;
		if (start >= end)
			return true;
		if (s.charAt(start) == s.charAt(end)) {
			return helper(start + 1, end - 1, s, deleteNum);
		} else {
			return helper(start + 1, end, s, deleteNum + 1) || helper(start, end - 1, s, deleteNum + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome2 v = new ValidPalindrome2();
		System.out.println(v.validPalindrome("deeee"));
	}

}
