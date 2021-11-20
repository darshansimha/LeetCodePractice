package DynamicProgramming;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		int[][] dp = new int[m][n];
		boolean hasObstruction = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0 && !hasObstruction) {
				dp[i][0] = 1;
			} else {
				hasObstruction = true;
			}
		}
		hasObstruction = false;
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 0 && !hasObstruction) {
				dp[0][i] = 1;
			} else {
				hasObstruction = true;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths2 u = new UniquePaths2();

		System.out.println(u.uniquePathsWithObstacles(new int[][] { { 0, 1 }, { 0, 0 } }));
	}

}
