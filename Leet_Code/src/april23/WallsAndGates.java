package april23;

import java.util.Arrays;
import java.util.Stack;


public class WallsAndGates {
	private class Position {
		int x;
		int y;
		int val;

		Position(int _x, int _y, int _val) {
			this.x = _x;
			this.y = _y;
			this.val = _val;
		}
	}

	public void wallsAndGates(int[][] rooms) {
		Stack<Position> stack = new Stack<>();
		int rows = rooms.length, cols = rooms[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rooms[i][j] == 0) {
					stack.push(new Position(i, j, 0));
				}

			}
		}

		Position curr = null;

		while (!stack.isEmpty()) {
			curr = stack.pop();
			calculateDistance(rooms, curr.x, curr.y, stack, curr);
		}
		
		System.out.println(Arrays.deepToString(rooms));

	}

	public void calculateDistance(int[][] grid, int i, int j, Stack<Position> stack, Position curr) {
		int rows = grid.length;
		int cols = grid[0].length;

		if (i - 1 >= 0) {
			if (grid[i - 1][j] != -1) {
				if (curr.val + 1 < grid[i - 1][j]) {
					grid[i - 1][j] = curr.val + 1;
					stack.push(new Position(i - 1, j, grid[i - 1][j]));
				}
			}
		}
		if (i + 1 < rows) {
			if (grid[i + 1][j] != -1) {
				if (curr.val + 1 < grid[i + 1][j]) {
					grid[i + 1][j] = curr.val + 1;
					stack.push(new Position(i + 1, j, grid[i + 1][j]));
				}
			}
		}
		if (j + 1 < cols) {
			if (grid[i][j + 1] != -1) {
				if (curr.val + 1 < grid[i][j + 1]) {
					grid[i][j + 1] = curr.val + 1;
					stack.push(new Position(i, j + 1, grid[i][j + 1]));
				}
			}
		}
		if (j - 1 >= 0) {
			if (grid[i][j - 1] != -1) {
				if (curr.val + 1 < grid[i][j - 1]) {
					grid[i][j - 1] = curr.val + 1;
					stack.push(new Position(i, j - 1, grid[i][j - 1]));
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inf = Integer.MAX_VALUE;
		WallsAndGates w = new WallsAndGates();
		
		w.wallsAndGates(new int[][] {{inf, -1, 0, inf}, {inf, inf, inf, -1}, {inf, -1, inf, -1}, {0, -1, inf, inf}});
	}

}
