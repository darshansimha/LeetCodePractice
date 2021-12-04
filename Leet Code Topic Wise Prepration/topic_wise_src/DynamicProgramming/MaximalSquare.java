package DynamicProgramming;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		if(rows == 0) {
			return 0;
		}
		int max = 0;
		int[][] dp = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i][j - 1]), dp[i - 1][j - 1]);
					if (dp[i][j] > max) {
						max = dp[i][j];
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max * max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximalSquare m = new MaximalSquare();

		System.out.println(m.maximalSquare(new char[][] {{'0'}}));
	}

}
