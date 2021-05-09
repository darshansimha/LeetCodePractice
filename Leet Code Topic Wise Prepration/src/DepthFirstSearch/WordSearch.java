package DepthFirstSearch;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if (word == null || board == null) {
			return false;
		}
		boolean result = false;
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					result = result || existRec(board, word, "", i, j);
				}
			}
		}
		return result;
	}

	public boolean existRec(char[][] board, String word, String current, int i, int j) {
		boolean result = false;
		if (current.equals(word)) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
				|| board[i][j] != word.charAt(current.length())) {
			return false;
		}
		char temp = board[i][j];
		current += board[i][j];
		board[i][j] = ' ';
		result = existRec(board, word, current, i - 1, j) || existRec(board, word, current, i + 1, j)
				|| existRec(board, word, current, i, j + 1) || existRec(board, word, current, i, j - 1);
		board[i][j] = temp;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch w = new WordSearch();

		System.out.println(w.exist(new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } }, "AAB"));
	}

}
