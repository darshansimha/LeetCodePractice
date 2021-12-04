package Matrix;

import java.util.Arrays;

public class MakingALargeIsland {
	public int largestIsland(int[][] grid) {
		int result = numIslands(Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new));
		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0) {
					grid[i][j] = 1;
					result = Math.max(result, numIslands(Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new)));
					grid[i][j] = 0;
				}
			}
		}

		return result;
	}

	private int numIslands(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					result = Math.max(result, dfs(i, j, grid, row, col, 0));
				}
			}
		}

		return result;
	}

	private int dfs(int i, int j, int[][] grid, int row, int col, int current) {
		if (i >= row || i < 0 || j < 0 || j >= col || grid[i][j] == 0) {
			return current;
		}
		grid[i][j] = 0;
		current += 1;
		int bottom = dfs(i + 1, j, grid, row, col, current);
		int top = dfs(i - 1, j, grid, row, col, current);
		int right = dfs(i, j + 1, grid, row, col, current);
		int left = dfs(i, j - 1, grid, row, col, current);

		return Math.max(Math.max(left, bottom), Math.max(top, right));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakingALargeIsland m = new MakingALargeIsland();
		System.out.println(m.largestIsland(new int[][] { { 1, 0 }, { 0, 1 } }));
	}

}
