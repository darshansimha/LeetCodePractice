package Dec_05;

public class AddBinary {
	public String addBinary(String a, String b) {
		int left = a.length() - 1;
		int right = b.length() - 1;

		StringBuilder result = new StringBuilder();

		int curr = 0;
		int carry = 0;
		while (left >= 0 || right >= 0) {
			if (left >= 0) {
				curr += (a.charAt(left) - '0');
			}
			if (right >= 0) {
				curr += (b.charAt(right) - '0');
			}
			curr += carry;

			if (curr == 3) {
				result.append(1);
				carry = 1;
			} else if (curr == 2) {
				result.append(0);
				carry = 1;
			} else {
				result.append(curr);
				carry = 0;
			}
			left--;
			right--;
			curr = 0;
		}
		
		if(carry != 0) {
			result.append(carry);
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("1010", "1011"));
	}

}
