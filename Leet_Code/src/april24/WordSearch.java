package april24;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		int cols = board[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int i, int j, String word, int currLen) {
		int rows = board.length;
		int cols = board[0].length;
		if (currLen == word.length()) {
			return true;
		}
		char temp = ' ';
		if (i < 0 || i >= rows || j < 0 || j >= cols || word.charAt(currLen) != board[i][j]) {
			return false;
		}
		temp = board[i][j];
		currLen++;
		board[i][j] = ' ';
		boolean found = dfs(board, i - 1, j, word, currLen) || 
						dfs(board, i + 1, j, word, currLen) || 
						dfs(board, i, j - 1, word, currLen) || 
						dfs(board, i, j + 1, word, currLen);
		board[i][j] = temp;
		return found;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch w = new WordSearch();
		System.out.println(w.exist(new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } }, "AAB"));
	}

}
