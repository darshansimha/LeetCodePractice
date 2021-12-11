package Dec_04;

public class StringToInteger_atoi {
	public int myAtoi(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		long MAX = Integer.MAX_VALUE;
		
		int sign = (s.charAt(0) == '-') ? -1 : 1;
		int idx = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;
		long result = 0;
		while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
			result = (result * 10) + (s.charAt(idx) - '0');
			if(result > MAX) {
				return (sign == -1)? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			idx++;
		}
		return sign * (int)result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringToInteger_atoi s = new StringToInteger_atoi();
		System.out.println(s.myAtoi("      -42"));
	}

}
