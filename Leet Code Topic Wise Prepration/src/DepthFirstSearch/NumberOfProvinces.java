package DepthFirstSearch;

public class NumberOfProvinces {
	public int findCircleNum(int[][] isConnected) {
		int result = 0;
		int rows = isConnected.length;
		
		boolean[] visited = new boolean[rows];
		
		for (int i = 0; i < rows; i++) {
			if(!visited[i]) {
				dfs(isConnected, i, visited);
				result++;
			}
		}

		return result;
	}

	public void dfs(int[][] isConnected, int row, boolean[] visited) {
		int cols = isConnected[0].length;
		for(int i = 0; i < cols; i++) {
			if(!visited[i] && isConnected[row][i] != 0) {
				visited[i] = true;
				dfs(isConnected, i, visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfProvinces n = new NumberOfProvinces();
		System.out.println(
				n.findCircleNum(new int[][] { { 1, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 1, 1 }, { 0, 0, 0, 1 } }));
	}

}
