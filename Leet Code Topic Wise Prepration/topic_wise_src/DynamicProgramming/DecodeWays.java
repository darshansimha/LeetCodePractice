package DynamicProgramming;

public class DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s == "0" || s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return s.charAt(0) == '0' ? 0 : 1;
		}
		int size = s.length();
		int[] dp = new int[size + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		
		for (int i = 2; i <= size; i++) {
			int oneDigit = s.charAt(i - 1) - '0';
			int twoDigits = Integer.valueOf(s.substring(i - 2, i));
			
			if(oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}
			if(twoDigits >= 10 && twoDigits <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[size];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("226"));
	}
}
