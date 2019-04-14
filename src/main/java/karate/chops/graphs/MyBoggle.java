package karate.chops.graphs;

public class MyBoggle {
	public static void main(String... strings) {
		printBoggleCombinations(new char[][] { { 'A', 'B' }, { 'C', 'D' } });
	}

	private static void printBoggleCombinations(char[][] board) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				helper(board, i, j, visited, "");
			}
		}
	}

	private static void helper(char[][] board, int row, int col, boolean[][] visited, String intermediate) {

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
			return;

		intermediate = intermediate + board[row][col];
		System.out.println(intermediate);
		
		visited[row][col] = true;
		helper(board, row - 1, col, visited, intermediate);
		helper(board, row + 1, col, visited, intermediate);
		helper(board, row, col - 1, visited, intermediate);
		helper(board, row, col + 1, visited, intermediate);
		helper(board, row - 1, col - 1, visited, intermediate);
		helper(board, row - 1, col + 1, visited, intermediate);
		helper(board, row + 1, col - 1, visited, intermediate);
		helper(board, row + 1, col + 1, visited, intermediate);
		visited[row][col] = false;
	}
}
