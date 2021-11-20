package Matrix;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					dfs(i, j, grid, row, col);
					result += 1;
				}
			}
		}

		return result;
	}

	private void dfs(int i, int j, char[][] grid, int row, int col) {
		if(i >= row || i < 0 || j < 0 || j >= col || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		
		dfs(i + 1, j, grid, row, col);
		dfs(i - 1, j, grid, row, col);
		dfs(i, j + 1, grid, row, col);
		dfs(i, j - 1, grid, row, col);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
