package karate.chops.graphs;

public class FindGroupsOfOnes {

	public static void main(String... args) {

		int[][] matrix = new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 0, 0, 0 } };
		System.out.println(findGroupsOfOnes(matrix));

		matrix = new int[][] { { 0, 1, 1, 0 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };
		System.out.println(findGroupsOfOnes(matrix));

	}

	private static int findGroupsOfOnes(int[][] matrix) {
		int count = 0;
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					helper(matrix, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	private static void helper(int[][] A, int row, int col, boolean[][] visited) {
		if (row < 0 || row >= A.length || col < 0 || col >= A[0].length || visited[row][col] || A[row][col] == 0)
			return;
		visited[row][col] = true;
		helper(A, row - 1, col, visited);
		helper(A, row + 1, col, visited);
		helper(A, row, col - 1, visited);
		helper(A, row, col + 1, visited);
		helper(A, row - 1, col - 1, visited);
		helper(A, row - 1, col + 1, visited);
		helper(A, row + 1, col - 1, visited);
		helper(A, row + 1, col + 1, visited);
	}
}
