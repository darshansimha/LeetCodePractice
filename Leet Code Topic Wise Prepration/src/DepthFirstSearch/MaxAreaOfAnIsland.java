package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MaxAreaOfAnIsland {

	public int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int row = grid.length;
		int cols = grid[0].length;

		int islandIndex = 0;
		List<Integer> islands = new ArrayList<Integer>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					islands.add(islandIndex, 0);
					sinkIsland(grid, i, j, islands, islandIndex);
					islandIndex++;
				}
			}
		}
		return (islands.size() == 0) ? 0 : Collections.max(islands);
	}

	public void sinkIsland(int[][] grid, int i, int j, List<Integer> islands, int index) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;

		islands.set(index, islands.get(index) + 1);
		sinkIsland(grid, i + 1, j, islands, index);
		sinkIsland(grid, i - 1, j, islands, index);
		sinkIsland(grid, i, j + 1, islands, index);
		sinkIsland(grid, i, j - 1, islands, index);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxAreaOfAnIsland m = new MaxAreaOfAnIsland();

		System.out.println(m.maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
	}

}
