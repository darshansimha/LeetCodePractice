package may4;

public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int result = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == '1') {
					result += numIslandsRec(grid, i, j);
				}
			}
		}
		return result;
	}
	public int numIslandsRec(char[][] grid, int i, int j) {
		int n = grid.length;
		int m = grid[0].length;
		
		if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != '1') {
			return 0;
		}
		grid[i][j] = '0';
		
		numIslandsRec(grid, i - 1, j);
		numIslandsRec(grid, i + 1, j);
		numIslandsRec(grid, i, j - 1);
		numIslandsRec(grid, i, j + 1);
		return 1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfIslands n = new NumberOfIslands();
		
		System.out.println(n.numIslands(new char[][]{
			  {'1','1','1','1','0'},
			  {'1','1','0','1','0'},
			  {'1','1','0','0','0'},
			  {'0','0','0','0','0'}
			}));
	}

}
