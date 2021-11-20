package Trees;

import java.util.HashSet;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean result = false;
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					visited.add(i + "," + j);
					result = result || dfs(board, word, i, j, String.valueOf(board[i][j]),visited);
					visited.remove(i + "," + j);
				}
			}
		}

		return result;
	}

	private boolean dfs(char[][] board, String word, int i, int j, String current, HashSet<String> visited) {
		int m = board.length;
		int n = board[0].length;
		if (current.equals(word)) {
			return true;
		}
		if (current.length() > word.length() || i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}
		boolean down = false, left = false, right = false, up = false;
		if (i + 1 < m && !visited.contains((i + 1) + "," + j)) {
			if (board[i + 1][j] == word.charAt(current.length())) {
				visited.add((i + 1) + "," + j);
				down =  dfs(board, word, i + 1, j, current + board[i + 1][j], visited);
				visited.remove((i + 1) + "," + j);
			}
		}
		if (i - 1 >= 0 && !visited.contains((i - 1) + "," + j)) {
			if (board[i - 1][j] == word.charAt(current.length())) {
				visited.add((i - 1) + "," + j);
				up =  dfs(board, word, i - 1, j, current + board[i - 1][j], visited);
				visited.remove((i - 1) + "," + j);
			}
		}
		if (j + 1 < n && !visited.contains(i + "," + (j + 1))) {
			if (board[i][j + 1] == word.charAt(current.length())) {
				visited.add(i + "," + (j + 1));
				right =  dfs(board, word, i, j + 1, current + board[i][j + 1], visited);
				visited.remove(i + "," + (j + 1));
			}
		}
		if (j - 1 >= 0 && !visited.contains(i + "," + (j - 1))) {
			if (board[i][j - 1] == word.charAt(current.length())) {
				visited.add(i + "," + (j - 1));
				left =  dfs(board, word, i, j - 1, current + board[i][j - 1], visited);
				visited.remove(i + "," + (j - 1));
			}
		}

		return up || down || right || left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch w = new WordSearch();
		System.out.println(w.exist(
				new char[][] {{'A'},{'A'}}, "AAA"));
	}

}
