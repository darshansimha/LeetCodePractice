package DepthFirstSearch;

public class NumberOfIslands {

	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int result = 0;
		int row = grid.length;
		int cols = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					result++;
					sinkIsland(grid, i, j);
				}
			}
		}
		return result;
	}

	public void sinkIsland(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		sinkIsland(grid, i + 1, j);
		sinkIsland(grid, i - 1, j);
		sinkIsland(grid, i, j + 1);
		sinkIsland(grid, i, j - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] c = new char[][]{
			  {'1','1','1','1','0'},
			  {'1','1','0','0','0'},
			  {'1','1','0','0','0'},
			  {'0','0','0','0','1'}
			};
			NumberOfIslands n = new NumberOfIslands();
			System.out.println(n.numIslands(c));
	}

}
