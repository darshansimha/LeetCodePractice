package DynamicProgramming;

public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		if (s.length() == 1) {
			return 1;
		}
		// The inspiration to solve the problem is to find out the longest common
		// subsequence between the current string and it's reverse.
		// So we reverse the current string and find the LCS between the 2

		StringBuilder sb = new StringBuilder(s);
		return longestCommonSubsequence(s, sb.reverse().toString());
	}

	private int longestCommonSubsequence(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					// If the chars are equal then it becomes 1 + longest without the equal chars
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					// If they are unequal then the LCS is the max of removing either of the current
					// chars
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		System.out.println(l.longestPalindromeSubseq("madam"));
	}

}
