package String;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		int left = num1.length() - 1;
		int right = num2.length() - 1;
		while (right >= 0 || left >= 0) {
			int curr = 0;
			if (right >= 0 && left >= 0) {
				curr = carry + (num1.charAt(left) - '0') + (num2.charAt(right) - '0');
			} else if (left >= 0) {
				curr = carry + (num1.charAt(left) - '0');
			} else {
				curr = carry + (num2.charAt(right) - '0');
			}
			carry = curr / 10;
			sb.append(curr % 10);
			left--;
			right--;
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
