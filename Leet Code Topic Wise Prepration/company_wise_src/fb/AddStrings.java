package Dec_05;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;

		int left = num1.length() - 1;
		int right = num2.length() - 1;

		int curr = 0;
		while (left >= 0 || right >= 0) {
			if (left >= 0) {
				curr = curr +  (num1.charAt(left) - '0');
			}
			if (right >= 0) {
				curr = curr + (num2.charAt(right) - '0');
			}
			curr += carry;
			carry = curr / 10;
			sb.append(curr % 10);
			left--;
			right--;
			curr = 0;
		}
		if (carry != 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddStrings a = new AddStrings();
		System.out.println(a.addStrings("11", "123"));
	}

}
