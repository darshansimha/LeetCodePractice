package String;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;

		int left = a.length() - 1;
		int right = b.length() - 1;

		while (left >= 0 || right >= 0) {
			int curr = 0;

			if (left >= 0 && right >= 0) {
				curr = carry + a.charAt(left) - '0' + b.charAt(right) - '0';
			} else if (left >= 0) {
				curr = carry + a.charAt(left) - '0';

			} else {
				curr = carry + b.charAt(right) - '0';
			}
			if (curr == 2) {
				sb.append(0);
				carry = 1;
			} else if (curr == 3) {
				sb.append(1);
				carry = 1;
			} else {
				carry = 0;
				sb.append(curr);
			}
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
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("1010", "1011"));
	}

}
