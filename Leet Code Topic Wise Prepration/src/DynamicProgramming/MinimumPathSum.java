package DynamicProgramming;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] dp = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i - 1 >= 0 && j - 1 >= 0) {
					dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
				} else if (i - 1 >= 0) {
					dp[i][j] = grid[i][j] + dp[i - 1][j];
				} else if (j - 1 >= 0) {
					dp[i][j] = grid[i][j] + dp[i][j - 1];
				} else {
					dp[i][j] = grid[i][j];
				}
			}
		}

		return dp[rows - 1][cols - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumPathSum m = new MinimumPathSum();

		System.out.println(m.minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));
	}

}
