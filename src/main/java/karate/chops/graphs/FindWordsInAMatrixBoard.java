package karate.chops.graphs;

public class FindWordsInAMatrixBoard {

    public static void main(String[] args) {
        FindWordsInAMatrixBoard f = new FindWordsInAMatrixBoard();
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        System.out.println(f.exist(board, "seed"));
        System.out.println(f.exist(board, "sad"));
        System.out.println(f.exist(board, "fad"));
    }

    private boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0)
            throw new IllegalArgumentException("invalid input");
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
        if (row < 0
                || row >= board.length
                || col < 0 || col >= board[0].length
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
