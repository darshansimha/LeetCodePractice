package Dec_04;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x%10 == 0 && x != 0)) {
			return false;
		}
		int temp = x;
		int reverse = 0;

		while (x > 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}

		return reverse == temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
