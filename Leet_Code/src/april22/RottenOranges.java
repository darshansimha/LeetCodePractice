package april22;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	private class Orange {
		int x;
		int y;
		int timeFrame;

		Orange(int _x, int _y, int _timeframe) {
			this.x = _x;
			this.y = _y;
			this.timeFrame = _timeframe;
		}
	}

	public int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		Queue<Orange> queue = new LinkedList<>();

		// Initialize all the rotten oranges at time 0
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.add(new Orange(i, j, 0));
				}
			}
		}
		Orange curr = null;
		while (!queue.isEmpty()) {
			curr = queue.poll();
			markAsRotten(grid, curr.x, curr.y, queue, curr);
		}
		// Test for fresh oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return curr.timeFrame;
	}

	public void markAsRotten(int[][] grid, int i, int j, Queue<Orange> queue, Orange curr) {
		int rows = grid.length;
		int cols = grid[0].length;

		if (i - 1 >= 0) {
			if (grid[i - 1][j] == 1) {
				grid[i - 1][j] = 2;
				queue.add(new Orange(i - 1, j, curr.timeFrame + 1));
			}
		}
		if (i + 1 < rows) {
			if (grid[i + 1][j] == 1) {
				grid[i + 1][j] = 2;
				queue.add(new Orange(i + 1, j, curr.timeFrame + 1));
			}
		}
		if (j + 1 < cols) {
			if (grid[i][j + 1] == 1) {
				grid[i][j + 1] = 2;
				queue.add(new Orange(i, j + 1, curr.timeFrame + 1));
			}
		}
		if (j - 1 >= 0) {
			if (grid[i][j - 1] == 1) {
				grid[i][j - 1] = 2;
				queue.add(new Orange(i, j - 1, curr.timeFrame + 1));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RottenOranges r = new RottenOranges();
		System.out.println(r.orangesRotting(new int[][] {{2,1,1}, {0,1,1}, {1,0,1}}));
	}

}
