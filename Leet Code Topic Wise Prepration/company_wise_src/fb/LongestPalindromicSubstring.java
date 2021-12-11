package Dec_04;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		if (s.length() == 1) {
			return s;
		}

		int len = s.length();

		int left = 0, right = 0;
		int resLen = 0;
		String res = "";
		for (int i = 0; i < len; i++) {
			// Odd Length Palindrome Case
			// We expand from the single character itself for e.g. b a b
			//Both left and right start at a and expand outwards
			left = i;
			right = i;
			while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				if(right - left + 1 > resLen) {
					resLen = right - left + 1;
					res = s.substring(left, right + 1);
				}
				left--;
				right++;
			}
			//Even Length Palindrome case
			// We see neighbouring chars and expand outwards
			//For example a b b a
			//left and right are both b's
			left = i; right = i + 1;
			while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
				if(right - left + 1 > resLen) {
					resLen = right - left + 1;
					res = s.substring(left, right + 1);
				}
				left--;
				right++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
