package String;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int left = 0;
		int right = s.length() - 1;
		
		while(left < right) {
			 while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
	                left++;
	            }
	            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
	                right--;
	            }

	            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
	                return false;
	            }
	            left++;
	            right--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome v = new ValidPalindrome();
		System.out.println(v.isPalindrome("race a car"));
	}

}
