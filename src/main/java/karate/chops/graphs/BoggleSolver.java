package karate.chops.graphs;

public class BoggleSolver {

    public static void main(final String[] args) {
        new BoggleSolver().printAllWordCombinations(new BoggleBoard(new char[][]{{'A', 'B'}, {'C', 'D'}}, 2, 2));
    }

    private void printAllWordCombinations(BoggleBoard board) {
        boolean[][] visited = new boolean[board.getRows()][board.getCols()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                boggleHelper(board, visited, i, j, "");
            }
        }
    }

    private void boggleHelper(BoggleBoard board, boolean[][] visited, int i, int j, String currentWord) {
        currentWord = currentWord + board.getCharacter(i, j);
        visited[i][j] = true;

        System.out.println(currentWord);

        for (int m = i - 1; m <= i + 1 && m < board.getRows(); m++) {
            for (int n = j - 1; n <= j + 1 && n < board.getCols(); n++) {
                if (m >= 0 && n >= 0 && !visited[m][n]) {
                    boggleHelper(board, visited, m, n, currentWord);
                }
            }
        }
        visited[i][j] = false;
    }
}

class BoggleBoard {
    char[][] board;
    int rows;
    int cols;

    public BoggleBoard(char[][] board, int rows, int cols) {
        this.board = board;
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public char getCharacter(int i, int j) {
        return board[i][j];
    }
}
