package Matrix;

public class LongestIncreasingPathInAMatrix {

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int result = 1;
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result = Math.max(result, dfs(i, j, dp, matrix, n, m));
			}
		}
		return result;
	}

	private int dfs(int i, int j, int[][] dp, int[][] matrix, int n, int m) {
		if (i < 0 || j < 0 || i >= n || j >= m) {
			return 0;
		}
		if (dp[i][j] > 0) {
			return dp[i][j];
		}
		int max = 0;
		if (i + 1 < n && matrix[i + 1][j] > matrix[i][j]) {
			max = Math.max(max, dfs(i + 1, j, dp, matrix, n, m));
		}
		if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
			max = Math.max(max, dfs(i - 1, j, dp, matrix, n, m));
		}
		if (j + 1 < m && matrix[i][j + 1] > matrix[i][j]) {
			max = Math.max(max, dfs(i, j + 1, dp, matrix, n, m));
		}
		if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
			max = Math.max(max, dfs(i, j - 1, dp, matrix, n, m));
		}
		dp[i][j] = max + 1;
		return dp[i][j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPathInAMatrix l = new LongestIncreasingPathInAMatrix();
		System.out.println(l.longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } }));
	}

}
