package april30;

public class MaximumLengthOfRepeatedSubarray {

	public int findLength(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int result = Integer.MIN_VALUE;
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}

		return result == Integer.MIN_VALUE ? 0 : result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumLengthOfRepeatedSubarray m = new MaximumLengthOfRepeatedSubarray();

		System.out.println(m.findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));
	}

}
