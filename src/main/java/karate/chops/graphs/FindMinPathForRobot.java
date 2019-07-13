package karate.chops.graphs;

//1 - flat, 0 - trench, 9 - target
//up,down,left,right allowed
public class FindMinPathForRobot {
    public static void main(String[] args) {
        System.out.println(getMinPath(new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 9}
        }));
        System.out.println(getMinPath(new int[][]{
                {1, 9, 0},
                {1, 1, 0},
                {1, 1, 0}
        }));
        System.out.println(getMinPath(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 0, 0, 1, 1},
                {1, 9, 1, 1, 1},
                {1, 0, 1, 1, 0}
        }));
    }

    private static int getMinPath(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board[0][0] != 1)
            throw new IllegalArgumentException("invalid input");

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[] minPath = new int[]{Integer.MAX_VALUE};

        minPathHelper(board, visited, minPath, 0, 0, 0);
        return minPath[0];
    }

    private static void minPathHelper(int[][] board, boolean[][] visited, int[] minPath, int row, int col, int level) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] == 0)
            return;

        if (board[row][col] == 9) {
            minPath[0] = Math.min(minPath[0], level + 1);
            return;
        }

        visited[row][col] = true;
        minPathHelper(board, visited, minPath, row - 1, col, level + 1);
        minPathHelper(board, visited, minPath, row + 1, col, level + 1);
        minPathHelper(board, visited, minPath, row, col - 1, level + 1);
        minPathHelper(board, visited, minPath, row, col + 1, level + 1);
        visited[row][col] = false;
    }
}
