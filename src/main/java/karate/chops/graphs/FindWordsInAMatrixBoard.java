package karate.chops.graphs;

public class FindWordsInAMatrixBoard {

//	public static void main(String... strings) {
////		char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
//		char[][] board = { { 'b' }, { 'a' }, { 'b' } };
//		boolean isFound = false;
//		for (int i = 0; i < board.length; i++)
//			for (int j = 0; j < board[0].length; j++)
//				if (verifyWord(i, j, board, 0, "bbabab")) {
//					isFound = true;
//					break;
//				}
//
//		System.out.println(isFound);
//	}
//
//	private static boolean verifyWord(int i, int j, char[][] board, int k, String word) {
//		if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || word.charAt(k) != board[i][j])
//			return false;
//
//		if (k == word.length() - 1)
//			return true;
//		
//		char c = board[i][j];
//		board[i][j] = '*';
//		boolean isFound = verifyWord(i - 1, j, board, k + 1, word) 
//				|| verifyWord(i + 1, j, board, k + 1, word)
//				|| verifyWord(i, j - 1, board, k + 1, word) 
//				|| verifyWord(i, j + 1, board, k + 1, word);
//
//		board[i][j] = c;
//		return isFound;
//
//	}

	public static void main(String[] args) {
		FindWordsInAMatrixBoard f = new FindWordsInAMatrixBoard();
		char[][] board = { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' }, { 'a', 'd', 'e', 'e' } };
		System.out.println(f.exist(board, "seed"));
		System.out.println(f.exist(board, "sad"));
		System.out.println(f.exist(board, "fad"));
	}

//	public boolean exist(char[][] board, String word) {
//		boolean[][] visited = new boolean[board.length][board[0].length];
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				if (word.charAt(0) == board[i][j])
//					if (helper(i, j, board, word, 0, visited))
//						return true;
//			}
//		}
//		return false;
//	}
//
//	private boolean helper(int row, int col, char[][] board, String word, int index, boolean[][] visited) {
//		if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col]
//				|| board[row][col] != word.charAt(index))
//			return false;
//
//		if (index == word.length() - 1)
//			return true;
//
//		visited[row][col] = true;
//
//		boolean isFound = helper(row + 1, col, board, word, index + 1, visited)
//				|| helper(row - 1, col, board, word, index + 1, visited)
//				|| helper(row, col + 1, board, word, index + 1, visited)
//				|| helper(row, col - 1, board, word, index + 1, visited);
//
//		visited[row][col] = false;
//		return isFound;
//	}

	private boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (wordFound(board, i, j, visited, word, 0))
						return true;
				}
			}
		}
		return false;
	}

	private boolean wordFound(char[][] board, int row, int col, boolean[][] visited, String word, int level) {
		if (row < 0 || row > board.length - 1 
				|| col < 0 || col > board[0].length - 1 
				|| visited[row][col]
				|| board[row][col] != word.charAt(level))
			return false;
		
		if (level == word.length() - 1)
			return true;
		
		visited[row][col] = true;
		boolean isFound = wordFound(board, row, col + 1, visited, word, level + 1)
				|| wordFound(board, row, col - 1, visited, word, level + 1)
				|| wordFound(board, row - 1, col, visited, word, level + 1)
				|| wordFound(board, row + 1, col, visited, word, level + 1);
		visited[row][col] = false;
		
		return isFound;
	}
}
